String lastActivity= getLastActivity();
try {
            Intent fooActivity = new Intent(this,Class.forName(lastActivity))
            startActivity(fooActivity)
    } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }