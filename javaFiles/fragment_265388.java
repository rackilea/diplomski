@Override
public void myOnCheckedChangedHandler(String id, boolean check_status) {
    Toast.makeText(
            this,
            "You changed the status for the row with an id of " + id +
                    " the status is now " + new Boolean(check_status).toString(),
            Toast.LENGTH_SHORT).show();
}