private  void getRecentImages (){            
        String[] colums={MediaStore.Images.Media.DATA,MediaStore.Images.Media._ID};
        final String orderBy = MediaStore.Images.Media.DATE_ADDED + " DESC";
        Cursor imageCursor = getActivity().getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                colums,
                null,
                null,
                orderBy);
        count=imageCursor.getCount();
        arrayPath=new String[count];
        for (int i = 0; i <count; i++) {
            imageCursor.moveToPosition(i);
            int dataColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
            arrayPath[i] = imageCursor.getString(dataColumnIndex);
            //thumbnails[i] = MediaStore.Images.Thumbnails.getThumbnail(getActivity().getContentResolver(),id,MediaStore.Images.Thumbnails.MICRO_KIND,null);
        }
        imageCursor.close();

    }