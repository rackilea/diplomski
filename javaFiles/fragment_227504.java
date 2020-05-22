final EditText input1 = new EditText(MainActivity.this);
        final EditText input2 = new EditText(MainActivity.this);
        input1.setHint("Enter name1");
        input2.setHint("Enter Name2");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(input1);
        linearLayout.addView(input2);

        final AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Sign In Failed")
                .setCancelable(false)
                .setMessage("Invalid username or password").setView(linearLayout).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
        builder.show();
        builder.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input1.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    builder.dismiss();
                }
            }
        });