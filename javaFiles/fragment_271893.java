public static void main(String args[]) {

            Scanner sc = new Scanner (System.in);
            System.out.println ("Type nine float numbers two-dimensional array of similar type and size with line breaks, end by -1:");
            float[][] a = new float[3][3];
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    String line = sc.nextLine();
                    if ("-1".equals(line)){
                        break;
                    }
                    a[i][j]=Float.parseFloat(line);
                }
            }

            System.out.println("\n The result is:");

            try {
                float b[][] = clone(a);
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        System.out.print(b[i][j] + " ");
                    }
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Error!!!");
            }
        }