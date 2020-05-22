public static void main(String[] args) throws IOException {

           Scanner scan = new Scanner(System.in);
           Scanner sc = new Scanner(System.in);
           System.out.print("Enter number of arrays: ");
            int noOfArrays = scan.nextInt();
            String students[] = new String[noOfArrays];
            int idx=0;
            System.out.println("----------------------");

            System.out.println("Enter Student names and scores:");
            int scores[]=new int[noOfArrays];
            for ( idx = 0; idx < students.length; idx++){
                System.out.print("\t"+ (idx+1)+ ". Name ");
                sc.next(); // this is to skipping next line
                students[idx] = sc.nextLine();
                System.out.print("\tScore: ");
                    scores[idx] =sc.nextInt();        

            }

            for (int i=0;i<students.length;i++) {
                System.out.println("Name="+students[i]+"\tScore="+scores[i]  );// for printing student name and score
            }

       }