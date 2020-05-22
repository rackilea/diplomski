boolean checked) {
            if (checked)
                {
                Toast.makeText(checkbox1.getContext(), "Activo", Toast.LENGTH_LONG).show();
                btnHola.setVisibility(0);
                btnHola.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ActivitySaludo.class);
                        String saludo = txtNombre.getText().toString();
                        intent.putExtra(EXTRA_SALUDO, saludo);
                        startActivity(intent);
                }
            else 
            {

                Toast.makeText(checkbox1.getContext(), "Inactivo" Toast.LENGTH_SHORT).show();
            }
        }