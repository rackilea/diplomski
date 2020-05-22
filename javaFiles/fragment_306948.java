Scanner originalNumber = new Scanner(System.in); // number for input

ArrayList<Double> results = new ArrayList<Double>;// array for results

System.out.println("Enter a number: "); // asks for input

int firstNumber = originalNumber.nextInt();

for(int i=0; i<=firstNumber; i++){
    double secondNumber = Math.abs((firstNumber*Math.sin(firstNumber)));

    results.add(secondNumber);//add results to an array
}
for(int k:results)
    System.out.print(k+" ");

originalNumber.close();