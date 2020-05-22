public void draw() {
    String border = String.format("%0" + width +"d", 0).replace("0", "#");
    System.out.println(border); // top-border
    for (int i = 1; i < height-1; i++) {
        System.out.print("#"); 
        for (int j = 1; j < width-1; j++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
    System.out.println(border); // bottom-border
}