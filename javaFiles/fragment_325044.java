@Override
public void onClick(View v) {
    if(imgName.startsWith("dog") && v.getId() == R.id.Dog ||
            imgName.startsWith("cat") && v.getId() == R.id.Cat) {    
        nextImage();
    } else {
        //game over screen code(yet to write)
    } 
}