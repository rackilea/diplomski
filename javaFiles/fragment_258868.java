final Activity thisActivity = this;
AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
        builder.setMessage("Are you sure you want to delete this contact?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        UserSQL repo = new UserSQL(thisActivity);
                        repo.delete(_contact_Id);
                        Toast.makeText(thisActivity, "Contact Record Deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });