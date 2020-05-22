@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_ALL) {
                Intent intent = new Intent(StartActivity.this,Details.class);
                startActivity(intent);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }