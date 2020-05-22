public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int myArray[] = new int[10];
        for(int i = 0; i <= myArray.length-1; i++ ) {
            System.out.println("Enter Number: ");
            int nums = number.nextInt();
            myArray[i] = nums;
       }
       int sum = computeTotal(myArray);
       System.out.println("The numbers total up to: "+sum);
       int largest = getLargest(myArray);
       System.out.println("The largest number is: "+largest);
    }

    public static int computeTotal(int myArray[]) {
        int total = 0;
        for (int z : myArray){
            total += z;
        }
        return total;
    }
    public static int getLargest(int myArray[]) {
        int number = myArray[0];
        for(int i = 0; i < myArray.length; i++) {
            if(myArray[i] > number) {
                number = myArray[i]; 
            }
        }
        return number;
    }