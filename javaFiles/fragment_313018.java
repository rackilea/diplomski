if (v.getId() == R.id.ImageButton01) {

            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                // Toast.makeText(this, "Application Name", Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setClassName("com.xxx.your_package_name",
                        "com.xxx.your_class_name");

                startActivity(i);

            }
        }