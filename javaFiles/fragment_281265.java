Intent myintent= new Intent(FirstActivity.this,SecondActivity.class);
            SharedPreferences spref = this.getSharedPreferences("mynotifyid", MODE_WORLD_WRITEABLE);
            SharedPreferences.Editor spreedit = spref.edit();
            spreedit.putString("Name1", str1.toString());              
            spreedit.commit();
            startActivity(myintent);