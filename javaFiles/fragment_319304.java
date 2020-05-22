@Override
        public void onResponse(String response) {
            if (response != null) {
                try {

                    ..............
                    ..................   

                    for (int i = 0; i < get_result.length(); i++){

                        JSONObject result = get_result.getJSONObject(i);

                        ModelPetaniTerdekat petaniTerdekat = new ModelPetaniTerdekat();
                        petaniTerdekat.setNama(result.getString("nama"));

                        JSONObject kriteria = result.getJSONObject("jarak");
                        for (int z=0; z<kriteria.length(); z++){
                            petaniTerdekat.setJarak(kriteria.getString("distance"));
                            petaniTerdekat.setDurasi(kriteria.getString("duration"));
                        }

                        boolean isExist = isExist(petaniTerdekat.getNama());

                        if (!isExist) { // Not exist, Add now
                            nama.add(petaniTerdekat.getNama());
                            jarak.add(petaniTerdekat.getJarak());
                            durasi.add(petaniTerdekat.getDurasi());
                        }

                        dialog.closeDialog();
                    }

                    initRecylerView(view);

                } catch (JSONException e) {
                    dialog.message("Error : "+e.toString());
                    e.printStackTrace();
                }
            }else{
                dialog.message("Error : Tidak ada data !");
            }
        }