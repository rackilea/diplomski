static void drawCanvas(){
    System.out.println("     |     |     |     |     |");
    for (int i = 0; i < canvas.length; i++) {
        if (i!=0){
            System.out.print("|");
            if (i%5==0) {
                System.out.println();
                System.out.println("_____|_____|_____|_____|_____|");
                System.out.println("     |     |     |     |     |");
            }
        }

        if (canvas[i]==0) {
            if(i<10) {
                System.out.print("  " + i + "  ");
            }
            else {
                System.out.print("  " + i + " ");
            }
        }
        if (canvas[i]==1) System.out.print("  X  ");
        if (canvas[i]==2) System.out.print("  O  ");
    }
    System.out.print("|");
    System.out.println();
    System.out.println("     |     |     |     |     |");
}