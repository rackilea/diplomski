public void updateDetails()
    {
     extra.put("precio", Integer.parseInt(mTextoPrecio.getText().toString()));

                Log.d("outside:  ", String.valueOf(extra.get("precio")));


                //Cargo las cervezas a los Mapa de datos generales
                Barriles.put("Barriles",barriles);
                Botellas.put("Botellas",botellas);
                Monjitas.put("Monjitas",monjitas);

                //Cargo en el lote todos los Mapas de datos
                mLote.set(refPedido , Barriles, SetOptions.merge());
                mLote.set(refPedido , Botellas, SetOptions.merge());
                mLote.set(refPedido , Monjitas, SetOptions.merge());

                //Cargo al lote informacion extra
                mLote.set(refPedido, extra, SetOptions.merge());



                //Subo el lote
                mPedidoProgress.setVisibility(View.VISIBLE);
                mLote.commit().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(PedidoActivity.this, "Pedido Agregado",
                                Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(PedidoActivity.this, "Error agregando el pedido al servidor",
                                Toast.LENGTH_LONG).show();


                    }
                });

                // Bunch of code that is not relevant...
    }