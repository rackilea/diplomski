int PICKFILE_REQUEST_CODE=33; // class property

Intent intent = new Intent();
intent.setAction(Intent.ACTION_GET_CONTENT); // It helps to get Image Uri 
intent.setType("image/*"); // Filter only images to open
intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
startActivityForResult(intent, PICKFILE_REQUEST_CODE);