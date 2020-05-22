mYellowColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    String hexColor = "ADD YOUR HEX CODE HERE";
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(hexColor)));
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("toolbarColor",hexColor);
                    editor.commit();

                    }
                });