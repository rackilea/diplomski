String filePath = songs.get(viewPosition).getPath();
                                    Uri uri = FileProvider.getUriForFile(mContext, "com.simplemusicplayer.fileprovider", new File(filePath));
                                    Intent share = new Intent(Intent.ACTION_SEND);
                                    share.setType("audio/*");
                                    share.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                    share.putExtra(Intent.EXTRA_STREAM, uri);
                                    mContext.startActivity(Intent.createChooser(share, "Share Sound File"));