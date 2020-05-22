Imageview[] myImageViewArray = new ImageView[70];
int imageViewCounter=0;

and in your function

public void initialize() {
    map = DM.getMap();
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 10; j++) {
            if (map[i][j].isUsed()) {
                myImageViewArray[imageViewCounter]=new ImageView();
                myImageViewArray[imageViewCounter].setImageResource(R.drawable.walllr);
                imageViewCounter++;
            }
        }
    }
}