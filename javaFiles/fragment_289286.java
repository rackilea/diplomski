@Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs =
            getActivity().getSharedPreferences("message", Context.MODE_PRIVATE);
        {
            //this block is used for offsreen fragment, it will get update, when it go to forescreen
            boolean sayHello = prefs.getBoolean("say_hello", false);
            if(sayHello){
                locationTextView =
                    (TextView) myView.findViewById(R.id.mainTextView);//NullPointerException here
                locationTextView.setVisibility(View.VISIBLE);
                locationTextView.setText("Hello");
            }else{
                // say something elese
            }
        }
        {
            //this listener is for forescreen fragment, as soon as shared preferences will be updated,
            // listerner willbe called  and you can update your view depending on changed parameters
            prefs.registerOnSharedPreferenceChangeListener(
                new OnSharedPreferenceChangeListener(){

                    @Override
                    public void onSharedPreferenceChanged(
                        SharedPreferences sharedPreferences, String key
                    ){
                        if(key.equals("say_hello")){
                            boolean sayHello = sharedPreferences.getBoolean("say_hello", false);
                            if(sayHello){
                                locationTextView =
                                    (TextView) myView.findViewById(R.id.mainTextView);//NullPointerException here
                                locationTextView.setVisibility(View.VISIBLE);
                                locationTextView.setText("Hello");
                            }else{
                                // say something elese

                            }
                        }
                    }
                }
            );
        }
    }