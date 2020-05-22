else {
        Toast.makeText(getApplicationContext(),
                "Account Created Successfully", Toast.LENGTH_SHORT).show();

     // set firstboot to false here
        getSharedPreferences("BOOT_PREF", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstboot", false)
                    .commit();  

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }