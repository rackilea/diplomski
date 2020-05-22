public static void main(String[] args) {
    Figure f;
    int type = 1; // set type as required

    switch(type) {
        case 1:
            f = new Circle();
            break;
        case 2:
            f = new Rectangle();
            break;
        case 3:
            f = new Square();
            break;
        default:
            f = new Figure();
    }
}