//in onCreate
if (!ProductionActivity.settingLandscape) // if landscape set to portait
                {

                    portraitView.setVisibility(View.VISIBLE);
                    landscapeView.setVisibility(View.GONE);
                    findViewById(R.id.view_finder).setVisibility(View.VISIBLE);
                    findViewById(R.id.view_finder2).setVisibility(View.GONE);
                    ChangeToLandscape(false);

                } else
                {

                    portraitView.setVisibility(View.GONE);
                    landscapeView.setVisibility(View.VISIBLE);
                    findViewById(R.id.view_finder).setVisibility(View.GONE);
                    findViewById(R.id.view_finder2).setVisibility(View.VISIBLE);
                    ChangeToLandscape(true); 

                    android.view.ViewGroup.LayoutParams params1 = landscapeView.getLayoutParams(); //used to resize screen
                    params1.height = mDisplay.getWidth();
                    landscapeView.setLayoutParams(params1);

                }