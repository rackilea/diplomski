for (int i=0; i<lista.size();i++){
            String dato = lista.get(i).getData_type();
            String title = lista.get(i).getField_label();
            String id = lista.get(i).getField_name();


            if (dato.equals("Text")){
                TextView tv = new TextView(getApplicationContext());
                tv.setLayoutParams(lp);
                tv.setId(assignDifferentId)
                Lview.addView(tv);
                tv.setText("Ingrese "+title);
                EditText et = new EditText(getApplicationContext());
                et.setLayoutParams(lp);
               et.setId(assignDifferentId2)
                et.setInputType(InputType.TYPE_CLASS_TEXT);
                Lview.addView(et);
                et.setHint("Ingrese Datos");
            }
        }

        btnIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(plantilla.this, "El elemento es ", Toast.LENGTH_SHORT).show();
            }
        });