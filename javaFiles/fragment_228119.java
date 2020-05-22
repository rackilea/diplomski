Uri uri = CR.insert(URL, calEvent);                        

     int id = Integer.parseInt(uri.getLastPathSegment());                       

     Toast.makeText(this, "Created Calendar Event " + id,
            Toast.LENGTH_SHORT).show();