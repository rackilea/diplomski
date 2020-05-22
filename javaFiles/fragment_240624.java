ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

StringBuilder sb = new StringBuilder();

for (HashMap map : list) {
    Iterator it = map.entrySet().iterator();

    while (it.hasNext()) {
        sb.append(((Map.Entry) it.next()).getValue()).append(" ");
    }
    sb.append("\n"); // Use this if you want a line break.
}

String msg = sb.toString();

new AlertDialog.Builder(this)
        .setTitle("Product details")
        .setCancelable(false)
        .setMessage(msg)
        .setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something.
                dialogInterface.dismiss();
            }
        }).show();