BtnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            position = position + 1;
            imageView.setImageResource(imageAdapter.ImagesArray[position]);
            Toast.makeText(FullScreenActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
        }
    }); //note you should also write the code to check if the position exceeds the final value