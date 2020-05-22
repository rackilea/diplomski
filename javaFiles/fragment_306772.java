final ImageButton bandera_1 = (ImageButton) findViewById(R.id.bandera1_perfil);
                final ImageView fondo_bandera_1 = (ImageView) findViewById(R.id.background_1_perfil);
                bandera_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (background_1 == false) {
                            fondo_bandera_1.setBackgroundResource(R.drawable.fondodegradado);
                            background_1 = true;
                        } else {
                            fondo_bandera_1.setBackgroundColor(Color.parseColor("#ffffff"));
                            background_1 = false;
                        }
                    }
                });