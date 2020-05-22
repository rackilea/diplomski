.setNegativeButton("Rate App", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                   i.setData(Uri.parse("market://details?id=[your package name]"));
                   startActivity(i);
               }
           })