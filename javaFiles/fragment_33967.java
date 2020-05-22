public void function1(int id){
            Toast.makeText(this, "Set as ringtone" , Toast.LENGTH_SHORT).show();
            String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();

                  String path = sdcard + "/multi10/" + Global.currentboard + "/series10";


                    ringtonemove("MultiboardRing");

                    File k = new File(Global.k);

                        ContentValues values = new ContentValues();
                        values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
                        values.put(MediaStore.MediaColumns.TITLE, "MultiboardRing");
                        values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mpeg");
                        values.put(MediaStore.Audio.Media.ARTIST, "Unknown artist");
                        values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                        values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
                        values.put(MediaStore.Audio.Media.IS_ALARM, false);
                        values.put(MediaStore.Audio.Media.IS_MUSIC, false);

                        Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
                        getContentResolver().insert(uri,values);
                        getContentResolver().delete(uri,MediaStore.MediaColumns.TITLE + "=\"" + "MultiboardRing" +"\"", null);
                        Uri newUri = getContentResolver().insert(uri, values);

                        RingtoneManager.setActualDefaultRingtoneUri(
                          series10button.this,
                          RingtoneManager.TYPE_RINGTONE,
                          newUri);

        }