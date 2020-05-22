File file = new File(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/picture").getPath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
capturedImageUri = Uri.fromFile(File.createTempFile("myImages" + new SimpleDateFormat("ddMMyyHHmmss", Locale.US).format(new Date()), ".jpg", file));
intent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri);
startActivityForResult(intent, Util.REQUEST_CAMERA);