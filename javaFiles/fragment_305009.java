public static void main(String[] args) {

            int size;
            int passing;
            Scanner input = new Scanner(System.in);

            System.out.println("Size of Array: ");
            size = input.nextInt();

            System.out.println("Passing Grade: ");
            passing = input.nextInt();

            int [] score = new int [size];
            int [] passed= new int [size];
            int [] failed= new int [size];

            int index = 0;
            int max = 100;
            int min = 50;

            System.out.print("Original List:\n");
            for(int a =0; a<score.length; a++){
                score[a] = min + (int)(Math.random() * ((max-min) + 1) );
                System.out.print(score[a] + "\n");
            }

            System.out.print("Passed Values:\n");
            for(int a=0; a<score.length; a++){
                if (score[a] >= passing){
                    int res = (passed[index++] = score[a]);
                    System.out.print(res + "\n");
                }
            }
            System.out.print("Failed Values:\n");
            index = 0;
            for(int a=0; a<score.length; a++){
                if (score[a] <passing){
                    failed[index++] = score[a];
                    int res2 = (passed[index++] = score[a]);
                    System.out.print(res2 + "\n");
                }
            }
        }