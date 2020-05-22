int index = 0;
int[] imgRes = {R.id.image1, R.id.image2, R.id.image3, R.id.image4};
    Button btnNext = (Button) dialog.findViewById(R.id.btnNext);
btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    updateImage();
                }

            });
private void updateImage(){
    index++;
    if(index >= imgRes.lenght)
        index = 0;
    ImageView imageView = findViewById(R.id.myImage);
    imageView.setResource(imgRes[index])
}