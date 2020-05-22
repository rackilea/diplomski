void Shuffle() {
    switch(new Random().nextInt(3)) {
    case 0:
        W1 = findViewById(R.id.Wpozycja1);
        W2 = findViewById(R.id.Wpozycja2);
        W3 = findViewById(R.id.Wpozycja3);

        Wyb1 = findViewById(R.id.imageButton11);
        Wyb2 = findViewById(R.id.imageButton12);
        Wyb3 = findViewById(R.id.imageButton13);
        break;
    case 1:
        W2 = findViewById(R.id.Wpozycja1);
        W1 = findViewById(R.id.Wpozycja2);
        W3 = findViewById(R.id.Wpozycja3);

        Wyb2 = findViewById(R.id.imageButton11);
        Wyb1 = findViewById(R.id.imageButton12);
        Wyb3 = findViewById(R.id.imageButton13);
        break;
    case 2:
        W3 = findViewById(R.id.Wpozycja1);
        W2 = findViewById(R.id.Wpozycja2);
        W1 = findViewById(R.id.Wpozycja3);

        Wyb3 = findViewById(R.id.imageButton11);
        Wyb2 = findViewById(R.id.imageButton12);
        Wyb1 = findViewById(R.id.imageButton13);
        break;
    }
}