switch(id) {
        case R.id.action_newPool:
            Toast.makeText(getApplicationContext(),"Being Implemented", Toast.LENGTH_LONG).show();
             break;
        case R.id.action_logOut:
            ParseUser.logOut();
            Intent leaveIntent = new Intent (MyPoolsActivity.this, DispatchActivity.class);
            leaveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(leaveIntent);
            break;
    }