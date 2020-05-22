ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.tecnico_altera,
                    android.R.layout.simple_spinner_item);
    tecnico_altera1 = findViewById(R.id.tecnico_altera1);
    tecnico_altera1.setAdapter(adapter);

     ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(
            this, R.array.tecnico_altera,
            android.R.layout.simple_spinner_item);
    tecnico_altera2 = findViewById(R.id.tecnico_altera2);
    tecnico_altera2.setAdapter(adapter2);

     ArrayAdapter<CharSequence> adapter3 =ArrayAdapter.createFromResource(
            this, R.array.carro,
            android.R.layout.simple_spinner_item);
    carro = findViewById(R.id.carro);
    carro.setAdapter(adapter3);