public void onClick(View v) {
            if (helloWorld.getText().trim().length() == 0
                    || helloWorld.getText().trim().equals("stoppy")) {
                helloWorld.setText("starty");
            } else {
                helloWorld.setText("stoppy");
            }
        }