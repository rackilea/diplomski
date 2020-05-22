public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 10 integers:");
            int[] a = new int[10];

            for(int i =0; i < a.length; i++){
                a[i] = sc.nextInt();
            }
            double avg = average(a); //if average return something, then you must assign the value return somwhere.
            System.out.println(avg); // print the valued return - avg
        }
        public static int average(int [] array){
            int sum =0;
            for(int i = 0; i < array.length; i++){
                sum += array[i];
            }
            return (int)(sum/array.length); //must return if you specify return type
        }
        public static double average(double [] array){
            double sum =0;
            for(int i = 0; i < array.length; i++){
                sum += array[i];
            }
            return sum/array.length; //must return if you specify return type
        }