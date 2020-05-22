public boolean onKeyDown(int keyCode, KeyEvent event) {
            switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                CurrentClass.this.finish();
                Intent i = new Intent(CurrentClass.this, MainActivity.class);
                startActivity(i);
                return true;
            default:
                return false;
            }