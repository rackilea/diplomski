int x = 0;
int y = 0;
int I = 0;
int II = 0;
while(y <= 7){
    x = 0;
    while( x <= 12){
        if(map[y][x] == 0){
            Image img = new Image("res/tile1.png");
            img.draw(II,I);
        }
        if(map[y][x] == 1){
            Image img = new Image("res/tile0.png");
            img.draw(II,I);
        }
        if(map[y][x] == 2){
            Image img = new Image("res/tile3.jpg");
            img.draw(II,I);
        }
        x++;
        II = x * 100;
    }
    y++;
    I = y * 100;
}