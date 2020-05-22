private int PICK_IMAGE_REQUEST_CODE = 1;
btChoseFile = (Button)view.findViewById(R.id.btChoseFile);

    btStar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.setType("*/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST_CODE);

        }
    });




@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST_CODE){
            Toast.makeText(getActivity(),"On Activity Result in fragment",Toast.LENGTH_LONG).show();
        }
    }