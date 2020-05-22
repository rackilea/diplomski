final Button button = (Button)findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonWasClicked(button);
            }
        });