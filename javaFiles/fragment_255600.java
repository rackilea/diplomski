Handler handler1 = new Handler();
int langId = 1;
handler1.post(new Runnable() {
                @Override
                public void run() {
                    if (langId > 3) {
                       return;
                    }
                    Toast.makeText(KCRdestActivity.this, String.valueOf(langId++), Toast.LENGTH_LONG).show();
                    handler1.postDelayed(this, 2000);  // If delay time is constant!
                }
});