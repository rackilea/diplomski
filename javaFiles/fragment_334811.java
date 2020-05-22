public static void main(String []args){
        int currentPosition = 10;
        int nextPosition;
        do
        {
            nextPosition = currentPosition + 1;         
            System.out.println("nextPosition = " + currentPosition);
            currentPosition += 1;
            System.out.println("currentPosition = " + currentPosition);
        } while (currentPosition < 18);
     }