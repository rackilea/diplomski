public static void main(String[] args)  {
    Scanner in = new Scanner(System.in); 
    int row = 0, col = 0; 
    System.out.println("row:"); row = in.nextInt(); System.out.print("column:"); col = in.nextInt();

    for (int i = 0; i < row; i++) { 
        for (int j = 0; j < col; j++) { 
            System.out.print(" - ");
        }
        System.out.print("\n");     
        for (int j = 0; j < col; j++) { 
            System.out.print("| |");
        }
        System.out.print("\n");     
        for (int j = 0; j < col; j++) { 
            System.out.print(" - ");
        }
        System.out.print("\n");     
    }
}