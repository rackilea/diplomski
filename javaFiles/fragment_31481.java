int pos_l = 0;
int pos_a = 0;

void draw() {
    image(board, 0, 0); 

    // tokens

    int xl = fields.get(pos_l)[0] + fields.get(pos_l)[2] / 3;
    int yl = fields.get(pos_l)[1] + fields.get(pos_l)[3] / 3;
    fill(226, 53, 143); 
    ellipse(xl, yl, 30, 30);

    int xa = fields.get(pos_a)[0] + fields.get(pos_a)[2] * 2 / 3;
    int ya = fields.get(pos_a)[1] + fields.get(pos_a)[3] * 2 / 3;
    fill(1, 110, 203); 
    ellipse(xa, ya, 30, 30);  
}