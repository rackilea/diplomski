int x = Mouse.getX();
int y = Mouse.getY();
int playX = Main_Activity.apg.getWidth() / 2 - ((play_Original_Width * f) / 2);
int playY = Main_Activity.apg.getHeight() / 2 - ((play_Original_Height * f) / 2);

if (x > playX && x < playX+play_Original_Width && y > playY && y < playY + play_Original_Height) {
    // then your mouse coordinates are over your image.
}