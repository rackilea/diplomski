//BOTON REALIZAR PEDIDO
    mRealizarPedido = findViewById(R.id.pedido_boton_realizarPedido);
    mRealizarPedido.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

               // Bunch of code that is not relevant...


                // esta aprobado o no , y el precio del pedido
                extra.put("timestamp", FieldValue.serverTimestamp());
                extra.put("aprobado", false);

                calcularPrecio(editTextArray,nombres,posiciones);

            }

        }
    });