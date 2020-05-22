String[] proj = {
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.DATE_TAKEN,
            MediaStore.Video.Media.DURATION };

            videocursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,proj, null, null, null);