public class QuestionAnalyser extends AppCompatActivity {
        String question;
        String entityIdentified;
        static boolean identified = false;
        DatabaseReference entityRef;
        TranslatorServant t = new TranslatorServant();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_interface);

        }

        public void analyse(String userQues) {
            if (!(Interface.deviceLang.equals("en"))) {
                TranslatorServant t = new TranslatorServant();
                question = t.translateText(userQues);
            } else {
                question = userQues;
            }
            question = question.replaceAll("\\p{Punct}|\\d", "");
            final String[] words = question.split(" ");
            getEntity(words);
            // remove any logic that depends on the return of getEntity(words) from here
            // it is best if the logic is called from within the Firebase call
        }

        private void getEntity(final String[] words) {
            entityRef = FirebaseDatabase.getInstance().getReference().child("IRAdata").child("Entities");
            entityRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot entity : dataSnapshot.getChildren()) {
                        String[] synonyms = entity.child("syn").getValue().toString().split(",");
                        for (String syn : synonyms) {
                            for (String word : words) {
                                if (word.equalsIgnoreCase(syn) || question.equalsIgnoreCase(syn)) {
                                    mimicOtherMessage("found");
                                    entityIdentified = entity.getKey();
                                    identified = true;// under what condition will this be false
                                    // this is the best place to put the logic
                                    initialiseEntityServant(entityIdentified, question, words);
                                } else {
                                    identified = false;// I hope this condition for setting it to false is satisfactory
                                    mimicOtherMessage("Sorry, I have failed to understand your question");
                                    for (String yes : YesNo.yes) {
                                        for (String w : words) {
                                            if (w.equalsIgnoreCase(yes) || question.equalsIgnoreCase(yes)) {
                                                identified = true;
                                                entityIdentified = "basic";
                                            }
                                        }
                                        for (String no : YesNo.no) {
                                            for (String w : words) {
                                                if (w.equalsIgnoreCase(no) || question.equalsIgnoreCase(no)) {
                                                    identified = true;
                                                    entityIdentified = "basic";
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
            // the logic here will have to also be moved into the Firebase call
        }
    }