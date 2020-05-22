public ArrayList<HashMap<String, String>> getSDCardAudioFiles() {
        // if you want  file path and additional details
        ArrayList<HashMap<String, String>> audioFilesDetailList = new ArrayList<HashMap<String, String>>();
        // if you want only file path
        ArrayList<String> audioFilePath =new ArrayList<String>();
        // if you want only file name
        ArrayList<String> audioFileName =new ArrayList<String>();
            Cursor mCursor = getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[] { MediaStore.Audio.Media.DISPLAY_NAME,
                            MediaStore.Audio.Media.DATA }, null, null, null);

            int count = mCursor.getCount();

            HashMap<String, String> audioFileMap;
            while (mCursor.moveToNext()) {
                audioFileMap = new HashMap<String, String>();
                audioFileMap.put("FileName",mCursor.getString(mCursor
                                .getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                audioFileMap.put("FilePath", mCursor.getString(mCursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                if(audioFileMap.get("FileName").endsWith(".mp3")){
                    audioFilesDetailList.add(audioFileMap);

                    // if you want only file path
                    audioFilePath.add(audioFileMap.get("FilePath"));
                     // if you want only file name 
                    audioFileName.add(audioFileMap.get("FileName"));
                }
            }
            mCursor.close();
            //return the arraylist whichever u needed
            return audioFilesDetailList;
        }