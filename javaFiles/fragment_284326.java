Intent shareIntent =   ShareCompat.IntentBuilder.from(YourActivity.this)
                                                    .setChooserTitle("Share to")
                                                    .setType("video/*")
                                                    .setStream(Uri.fromFile(currentFile))
                                                    .getIntent();
                            if (shareIntent.resolveActivity(getPackageManager()) != null){
                                startActivity(shareIntent);
                            }