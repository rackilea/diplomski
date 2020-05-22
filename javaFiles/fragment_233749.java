public class QuizActivity extends AppCompatActivity {

                                            @Override
                                            protected void onCreate(Bundle savedInstanceState) {
                                                super.onCreate(savedInstanceState);
                                                mExplanationText = (TextView) findViewById(R.id.txtExplanation); //this is the text with which i want the visibility to be controlled from SettingsActivity

                                                SharedPreferences preferences = getSharedPreferences("SETTINGS", MODE_PRIVATE);
                                                boolean b=preferences.getBoolean("ntoificatoin",false);//it returns stored boolean value else returns false


                                                if(b){

                                                    //return true from Settings 
                                                    //do what you want to
                                                    mExplanationText.setText("   "+b);
                                                }
                                                else
                                                {
                                                    //return false from Settings 
                                                    //do what you want to
                                                    mExplanationText.setText("   "+b);

                                                }

                                            }
        }