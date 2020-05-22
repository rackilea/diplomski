String primeNumbers = "";
    for (int i = 1, num = 0; i <= limit; i++) {
        int counter = 0;
        for (num = i; num >= 1; num--) {
            if (i % num == 0) {
                counter = counter + 1;
            }
        }
        if (counter == 2) {

            primeNumbers += i + " ";
        }
    }

    TextView textView = (TextView) findViewById(R.id.textView);
    textView.setText(primeNumbers);