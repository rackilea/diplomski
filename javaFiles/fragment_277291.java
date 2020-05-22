//generate random number between 0 and image.length
int img1 = (int) Math.round((Math.random() * images.length));
int img2 = (int) Math.round((Math.random() * images.length));
int img3 = (int) Math.round((Math.random() * images.length));
int img4 = (int) Math.round((Math.random() * images.length));

int whichImg = (int) Math.round((Math.random() * 4));

if(whichImg == 1){
   whichImg = img1;
} else if(whichImg == 2){
   whichImg = img2;
} else if(whichImg == 3){
   whichImg = img3;
} else {
   whichImg = img4;
}

int outlineID = outlines[whichImg];