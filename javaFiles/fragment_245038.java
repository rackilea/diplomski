final Cursor cursor = dab.alldata();

if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"NO DATA", Toast.LENGTH_LONG).show();
        } else{
            while(cursor.moveToNext()){
                if(cursor.getString(7).equals(categoria)) {
                    nomeFlor = cursor.getString(1);
                    arrayListSelected.add(nomeFlor);

                }
            }
        }