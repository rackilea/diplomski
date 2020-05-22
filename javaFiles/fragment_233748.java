mExplanationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                        SharedPreferences preferences = getSharedPreferences("SETTINGS", MODE_PRIVATE);
                                        Editor editor = preferences.edit();
                                        if(isChecked){
                                            editor.putBoolean("ntoificatoin",isChecked);
                                        }
                                        else
                                        {
                                            editor.putBoolean("ntoificatoin",isChecked);

                                        }

                                        editor.apply();
                                        // how do i toggle visibility of mExplanation text in my QuizActivity.java from here?
                                    }
                                });