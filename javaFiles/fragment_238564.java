JsonObject jsonObject = new JsonObject();
jsonObject.addProperty("metodo", "inserisciLuogo");
jsonObject.addProperty("latitudine", latitudine);
jsonObject.addProperty("longitudine", longitudine);
jsonObject.addProperty("nome", nome);
jsonObject.addProperty("indirizzo", indirizzo);
jsonObject.addProperty("Utente_idUtente", Utils.getUserID(getApplicationContext()));

Log.e(TAG, jsonObject.toString());

Ion.with(getApplicationContext())
        .load(URL)
        .setJsonObjectBody(jsonObject)
        .asJsonObject()
        .setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                if (result != null) {
                    Boolean risultato = result.get("risultato").getAsString().equals("1");
                    Log.e(TAG, risultato.toString());
                    if(risultato)
                        Toast.makeText(getApplicationContext(), getString(R.string.place_added), Toast.LENGTH_LONG).show();
                     else
                        Toast.makeText(getApplicationContext(), getString(R.string.place_add_error), Toast.LENGTH_LONG).show();
                 }
                 else
                    Toast.makeText(getApplication(), getString(R.string.error_no_server), Toast.LENGTH_LONG).show();
                }
            });