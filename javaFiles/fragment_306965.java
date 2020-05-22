asikki.setText(deneme[0][0]);
    asikki.setBackgroundColor(Color.BLACK);
    asikki.setTextColor(Color.WHITE);

    asikki.setOnClickListener(new View.OnClickListener() {
        int say = 1;
        public void onClick(View v) {
                // TODO check say isn't out of bound
            asikki.setText("A) " +deneme[say++][0]);
        }
    });