@Override
public void onClick(View v) {
    switch(v.getId()) {
        case R.id.take_pic_button:
            takepic = true;
            choosepic = false;
            Intent i1 = new Intent(this, TakePictureActivity.class);
            startActivity(i1);
            break;
        case R.id.choose_pic_button:
            choosepic = true;
            takepic = false;
            Intent i2 = new Intent(this, ChoosePicActivity.class);
            startActivity(i2);
            break;
    }
}