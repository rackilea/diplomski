int width = 10;
        int height = 10;

        int middle = width % 2 == 0 ? (width / 2) - 1 : width / 2;
        int heightRoof = middle+1;

        for (int i = 0 ; i < heightRoof ; i++){
            for (int j = middle - i - 1 ; j >= 0 ; j--){
                System.out.print(".");
            }
            if (i == 0) {
                System.out.print("**");
                System.out.println();
                continue;
            } else {
                System.out.print("/");
                for (int k = 0 ; k < 2*i ; k++){
                    System.out.print(".");
                }
            }
            System.out.print("\\");
            System.out.println();
        }

        for (int i = 0 ; i < width ; i++){
            System.out.print("-");
        }