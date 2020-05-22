// Now returns int array instead of String
public static int [] getLottoTicket(){
        Random lottoNumbers = new Random();  //random object
        int [] ticket = new int[6];  //6 lotto numbers
        int counterr = 0;
        int a;
        for( int counter = 0; counter < ticket.length; ++counter ){
            ticket[counter] = (1 + lottoNumbers.nextInt(45) );  //numbers between 1-45
        }
        Arrays.sort( ticket );      //array class .. sorts array

        return ticket;
}

public static void main( String [] args ){
   int a, d, n=1, t, b;
    int totalConsecutives = 0;
    for(int i=1; i<1000000; i++){
        int counter = 0;
        int [] lottoTicket = getLottoTicket();

        // Keep a count of consecutives
        totalConsecutives += getConsecutiveNumbers( lottoTicket );
   }
    System.out.println("Number of consecutives: " + totalConsecutives );
}