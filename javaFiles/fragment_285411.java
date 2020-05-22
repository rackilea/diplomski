case 0:
    switch (childPosition) {
        case 0:
            if (NetworkManager.isNetworkAvailable(this)) {
                new UserAwayTask().execute();
            } else
                Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
            break;

        case 1:
            selection = null;
            selectionArgs = null;
            break;
        case 2:
            selection = Employee.COL_COUNTRY + " IS ? COLLATE NOCASE";
            selectionArgs = new String[]{valueReceived};
            break;
    }
break; //¯\_(ツ)_/¯