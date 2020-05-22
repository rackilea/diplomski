String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

            String[] projection = {
                    MediaStore.Audio.Media.DATA,
                    };

            Cursor cursor = getActivity().managedQuery(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    selection,
                    null,
                    null);

            while(cursor.moveToNext()){
            //do something with the path
            File f=new File(cursor.getString(0));
            System.out.println(cursor.getString(0));
            }