new MaterialAlertDialogBuilder(MainActivity.this,
            .setTitle("Dialog")
            .setMessage("Write your message here. ....")
            .setPositiveButton("Ok", /* listener = */ null)
            .setNegativeButton("Cancel", /* listener = */ null)
            .show();