public static void main(String[] args) {    
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();      
    System.out.println(getSignAndParity(number));
}

public static String getSignAndParity(int num) { 
    if(num == 0)
        return "Error";         
    String sign = num>0?"Positive":"Negative";
    String parity = Math.abs(num)%2==0?"Even":"Odd";
    return sign + " " + parity;   
}