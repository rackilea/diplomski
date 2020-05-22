btn_anadir_lista.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {    // Acciones que realiza el botón btn_anadir_lista
            String time = new SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis());

            Lista lista = new Lista(
                    nombre_nueva_lista.getText().toString(),
                    DateFormat.getDateInstance().format(Calendar.getInstance().getTime()) + "\n" +
                            time,
                    "Ubicación respectiva", 1);
            db.listaDao().insertAll(lista);
            startActivity(new Intent(AnadirLista.this,MainActivity.class));  
            //  ^ Luego de añadir el nuevo elemento a la DB, la vista regresa a activity_main.xml
        }
    });