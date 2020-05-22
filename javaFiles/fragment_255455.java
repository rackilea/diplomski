@Override
public void onClick(View view) {
    switch (view.getId()) {
        case R.id.btnCapture:

                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.custom_dialog_box);
                    dialog.setTitle("Select Image");
                    Button dialogButton = (Button) dialog.findViewById(R.id.btnExit);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    Button btnChoosePath = (Button) dialog.findViewById(R.id.btnChoosePath);
                    btnChoosePath.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(View v) {
                            activeGallery();
                            dialog.dismiss();
                        }
                    });
                    Button btnTakePhoto = (Button) dialog.findViewById(R.id.btnTakePhoto);
                    btnTakePhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            activeTakePhoto();
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

            break;
    }

}