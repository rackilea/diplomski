public class ForumPostTopic extends AppCompatActivity {

        public static final String TAG = "TAG";
        EditText editTopic, editContent;
        Button addTopicBtn;
        FirebaseFirestore fStore;
        FirebaseAuth fAuth;
        Date date_published;
        String userID;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forum_post_topic);

            editTopic = findViewById(R.id.editTopic);
            editContent = findViewById(R.id.editContent);
            addTopicBtn = findViewById(R.id.addTopicBtn);

            fAuth = FirebaseAuth.getInstance();
            userID = fAuth.getCurrentUser().getUid();

            fStore = FirebaseFirestore.getInstance();

            date_published = Calendar.getInstance().getTime();



            addTopicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final ArrayList<String> author = new ArrayList<>();


                    // getting the user
                    DocumentReference userRef = fStore.collection("users").document(userID);
                    userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            DocumentSnapshot user = task.getResult();
                            if(task.isSuccessful()) {
                                if (user.exists()) {
                                    Log.d(TAG,"Got the user " + userID);
                                    String author_temp = user.get("fname").toString() + " " + user.get("lname").toString();
                                    author.add(0,author_temp);
                                    setTopic(author);
                                    setPost(author);
                                } else {
                                    Log.d(TAG,"No such user");
                                }
                                notifyAll();
                            }

                            else {
                                Log.d(TAG, "get failed with ", task.getException());
                            }
                        }
                    });

                }
            });

        }

        private void setTopic(ArrayList<String> author){
            String topic = editTopic.getText().toString().trim();
            DocumentReference topicRef = fStore.collection("forum_topics").document();
            Map<String, Object> addTopic = new HashMap<>();
            addTopic.put("topic_name", topic);
            addTopic.put("date_published", date_published);
            addTopic.put("author", author.get(0));
            topicRef.set(addTopic).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG,"New Topic document created");
                }
            });
        }

        private void setPost(ArrayList<String> author){
            String topic = editTopic.getText().toString().trim();
            String content = editContent.getText().toString().trim();
            DocumentReference postRef = fStore.collection("forum_posts").document();
            Map<String, Object> addPost = new HashMap<>();
            addPost.put("topic_name", topic);
            addPost.put("date_published", date_published);
            addPost.put("author", author.get(0);
            addPost.put("content", content);
            postRef.set(addPost).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG,"New Post document created");
                }
            });
        }
    }