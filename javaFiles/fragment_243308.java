final ArrayList<Word> numbers = new ArrayList<Word>(); //edited this

  numbers.add(new Word("one", "onu", R.drawable._nmbericon,"unoo"));

                    WordAdapter adapter = new WordAdapter(this, numbers);
                    ListView listView = (ListView) findViewById(R.id.listview);

                    listView.setAdapter(adapter);
    //->> TEXT TO SPEECH STARTS HERE
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        textToSpeech = new TextToSpeech(NumbersActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                  //And edited Here
                                if (status == TextToSpeech.SUCCESS){
                                    result = textToSpeech.setLanguage(Locale.ENGLISH);
                        Word num = numbers.get(position);
                        result = textToSpeech.setLanguage(Locale.ENGLISH);
                        String toSpeak = num.getPronunciation();
                        Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                }else{
                                    Toast.makeText(getApplicationContext(), "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });
                  //->> TEXT TO SPEECH ENDSHERE