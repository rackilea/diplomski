PGraphics board;

void setup() {

    // [...]

    size(700, 700);  
    board = createGraphics(700, 700);
    board.beginDraw();

    board.background(205,230,208);

    // four squares on each corner
    board.strokeWeight(4);
    board.stroke(0);
    board.noFill();

    for(int[] f : fields) {
        board.rect(f[0], f[1], f[2], f[3]);
    }   

    // [...]

    board.endDraw();
}