if (idc != null) {
        if (!SharedPrefManager.getInstance(getApplicationContext()).getHisto()) {
            db.deleteAll();
            getthingy();
       }

    } else {
        Intent intent = new Intent(historique.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }