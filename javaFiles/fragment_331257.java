View view1 = getLocalActivityManager().startActivity(
                            "ReferenceName",
                            new Intent(getApplicationContext(),
                                    YourActivityClass.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();
                    setContentView(view1);