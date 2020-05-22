File path = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES);
Uri uri = Uri.fromFile(path);
Intent intent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.myfiles");
intent.setAction("samsung.myfiles.intent.action.LAUNCH_MY_FILES");
                    intent.putExtra("samsung.myfiles.intent.extra.START_PATH", path.getAbsolutePath());
startActivity(intent);