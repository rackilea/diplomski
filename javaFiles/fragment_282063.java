private void calcularPrecio(final EditText[] editTextArray, final String[] nombres, final List<Integer> posiciones) {

    mBaseDatos.collection("Precios").document("precios").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

            if (task.isSuccessful()) {


                    Log.d("inside:  ", String.valueOf(extra.get("precio")));
                    updateDetails();

                } else {

                    Log.d(TAG, "No existe el documento");

                }

            } else {

                Log.d(TAG, "get fallo con la exepción: ", task.getException());

            }

        }
    });

}