showBusinessOrPrivateStartDialog() {
    if(dialog == null) {
    dialog = build.create();
    }
    }


    builder.setPositiveButton("Business", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    CallClassification.showBusinessCallPopup(context, call);
                 }
              });

builder.setOnDismissListener(new OnDismissListener() {
public void onDismiss() {
dialog = null;
}
}