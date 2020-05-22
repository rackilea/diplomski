Scanner input = new Scanner (System.out).useDelimiter("\n");
int values[] = new int[10];
.
.
.


for ( int i = 0 ; i < values.length ; i++ ){
     System.out.print(" please enter the numer "  +i);
     values[i] = input.nextInt();
}