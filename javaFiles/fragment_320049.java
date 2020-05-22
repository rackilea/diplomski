class Adding{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int subtotal = 0;
        int total = 0; 
        int numbersRead=0;
        while(true){
            while(true){
                int number = input.nextInt();
                numbersRead++;
                if(number == 0)break;
                subtotal = subtotal + number;
            }
            total = total + subtotal;
            if(subtotal != 0 || numbersRead == 1){
                System.out.println("subtotal: " + subtotal);
                subtotal = 0;
            }else{
                System.out.println("total: " + total);
                break;
            }
        }
    }
}