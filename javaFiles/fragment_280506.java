if(cursor!=null{
 cursor.moveToFirst();
            do {
                String numObra = 
 cursor.getString(cursor.getColumnIndex(BancoDadosHelper.COLUNA_NUM_OBRA));
                String descObra = 
 cursor.getString(cursor.getColumnIndex(BancoDadosHelper.COLUNA_DESCRICAO_OBRA));
                String geoReferenciamento = 
 cursor.getString(cursor.getColumnIndex(BancoDadosHelper.COLUNA_GEOREFERENCIAMENTO 
 ));
                String tipoObra = 
 cursor.getString(cursor.getColumnIndex(BancoDadosHelper.COLUNA_TIPO_OBRA));
                Obra novaObra = new Obra(numObra, descObra, tipoObra, 
 geoReferenciamento);
                listaMapa.add(novaObra);

            } while (cursor.moveToNext());


 }