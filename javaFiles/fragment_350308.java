public static void dialogUpozorenjaTest(..., final Runnable func){
    //.....
        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                func.run();
            }
          });
}