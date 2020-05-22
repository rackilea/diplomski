private void deleteItem(model item){
    switch (type){
        case AUDIOS:{
            int b=getContentResolver().delete(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    MediaStore.MediaColumns.DATA + "='" + item.getPath().getPath() + "'", null
            );
            Log.e(TAG,"b: "+b);
            break;
        }
        case IMAGES:{
            int b=getContentResolver().delete(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    MediaStore.MediaColumns.DATA + "='" + item.getPath().getPath() + "'", null
            );
            Log.e(TAG,"b: "+b);
            break;
        }
        case VIDEOS:{
            int b=getContentResolver().delete(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    MediaStore.MediaColumns.DATA + "='" + item.getPath().getPath() + "'", null
            );
            Log.e(TAG,"b: "+b);
            break;
        }
        case COMPRESSED:
        case APPS:
        case DOCUMENTS :{
            int bex=getContentResolver().delete(
                    MediaStore.Files.getContentUri("external"),
                    MediaStore.MediaColumns.DATA + "='" + item.getPath().getPath() + "'", null
            );
            int bin=getContentResolver().delete(
                    MediaStore.Files.getContentUri("internal"),
                    MediaStore.MediaColumns.DATA + "='" + item.getPath().getPath() + "'", null
            );
            Log.e(TAG,"bex: "+bex);
            Log.e(TAG,"bin: "+bin);
            break;
        }

    }
}