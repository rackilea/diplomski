public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a four digit pin:");
    int digit = scan.nextInt(); // scanning for user input as INT
    String hexDigit = Integer.toHexString(digit); //convert PIN to hex

    int one = ((int)(Math.random()+1000)*10000); //two randoms bw 1000 and 10000
    int two = ((int)(Math.random()+1000)*10000);

    String oneStr = Integer.toHexString(one); //convert to hex
    String twoStr = Integer.toHexString(two); //convert to hex

    System.out.println(oneStr + hexDigit + twoStr); //print concated
}