public void onActivityResult(int requestcode,int resultcode,final Intent intent) {
    super.onActivityResult(requestcode, resultcode, intent);
    if (resultcode == RESULT_OK) {
        if (requestcode == 101) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("Save", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //Do nothing here. Because image is already saved but if you want to save it other place then do code.
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //Do here code for for deleting image using uri
                }
            });
            final AlertDialog dialog = builder.create();
            LayoutInflater inflater = getLayoutInflater();
            View dialogLayout = inflater.inflate(R.layout.go_pro_dialog_layout, null);
            dialog.setView(dialogLayout);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.show();

            final ImageView image = (ImageView) dialog.findViewById(R.id.goProDialogImage);
            Bitmap photo = (Bitmap) intent.getExtras().get("data");
            image.setImageBitmap(photo); //Edited here





        }
    }
}