if(data!=null) { 
                     Bitmap thePic = (Bitmap) data.getExtras().get("data");
                     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
                     String filename = preferences.getString("file_name", ""); // value to retrieve
                     String path = Environment.getExternalStorageDirectory()+"/PetSitter/Pet Images/" + filename;
                     img.setImageURI(Uri.parse(path.toString()));
                     } else {
                     // In createNewFile, make sure you already saved the filename (prefix+System.currentTimeMillis()+".jpg"), for example, to sharedpreferences then get the filename and apply in path 
                     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
                     String filename = preferences.getString("file_name", ""); // value to retrieve
                     String path = Environment.getExternalStorageDirectory()+"/PetSitter/Pet Images/" + filename;
                     BitmapFactory.Options bfo = new BitmapFactory.Options();
                     bfo.inSampleSize = 1;
                     Bitmap bmp = BitmapFactory.decodeFile(path, bfo);
                     img.setImageBitmap(bmp);
                    }