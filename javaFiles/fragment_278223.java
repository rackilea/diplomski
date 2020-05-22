import java.util.*;
public class patternGenerator  {
    private static Scanner input;
    public static void main(String[] args)   {      
    char[] anArray = {'!','@','#','$','%','^','&','*','+','=','~','<','>','?'}; 
    int symbolsPerLine = 0, printed, dontStop = 1, difSymbols;
    input = new Scanner(System.in);
    System.out.println("Enter the amount of symbols to use: ");
    difSymbols = input.nextInt();
    while (difSymbols > anArray.length) {
        difSymbols = (anArray.length-1);
    }
    System.out.println("Dif symbols are: "+ difSymbols);
    System.out.println("Enter amount of symbols per row: ");


    symbolsPerLine = input.nextInt();

    System.out.println("Amount of symbols per line are: "+ symbolsPerLine);
    char [] patternArray = new char[symbolsPerLine];

    int srcIndex =0;
    for(j=0; j < symbolsPerLine; j++) {
       patternArray[j] = anArray[srcIndex];
      srcIndex++;
      if(srcIndex> (anArray.length-1)) srcIndex =0;

    }

    System.out.print(patternArray);