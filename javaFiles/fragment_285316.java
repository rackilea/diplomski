public class MyDecimalToString {

public static String getString(int number){
    switch(number){
    case 0:
        return "Zero";
    case 1:
        return"One";
    case 2:
        return"Two";
    case 3:
        return"Three";
    case 4:
        return"Four";
    case 5:
        return"Five";
    case 6:
        return"Six";
    case 7:
        return"Seven";
    case 8:
        return"Eight";
    case 9:
        return"Nine";
    case 10:
        return "Ten";
    case 11:
        return "Eleven";
    case 12:
        return "Twelve";
    case 13:
        return "Thriteen";
    case 14:
        return "Fourteen";
    case 15:
        return "Fifteen";
    case 16:
        return "Sixteen";
    case 17:
        return "Seventeen";
    case 18:
        return "Eighteen";
    case 19:
        return "Nineteen";      
    }
    return "";
}

public static String getTeen(int num){

    switch (num) {
    case 2:
        return "Twenty";
    case 3:
        return "Thirty";
    case 4:
        return "Fourty";
    case 5:
        return "Fifty";
    case 6:
        return "Sixty";
    case 7:
        return "Seventy";
    case 8:
        return "Eighty";
    case 9:
        return "Ninety";
    }
    return "";

}

//This method will provide whole number string representation 
public static String getWholeWord( int number){

    String output="";
    int input=0;

    String inputNumberString=String.valueOf(number);

    int lastNum=Integer.valueOf(inputNumberString.substring(inputNumberString.length()-1,inputNumberString.length()));
    int numberBeforeLast=(number>9?(Integer.valueOf(inputNumberString.substring(inputNumberString.length()-2,inputNumberString.length()-1))):0);

    if(number>=1000){
        input=number/1000;
        output=getWholeWord(input)+" Thousand ";            
    }
    input=number%1000;
    if(input>=100){
        int tempNum=input/100;
        output+=getString(tempNum)+" Hundread ";
    }

    if(numberBeforeLast>0){
        int tempNum=input;
        if(numberBeforeLast==1){
            tempNum=Integer.valueOf(String.valueOf(numberBeforeLast)+lastNum);
            output+=getString(tempNum);
            lastNum=0;
            numberBeforeLast=1;
        }else{
            output+=getTeen(numberBeforeLast)+" ";                          
        }
    }

    if(lastNum>0){
        output+=getString(lastNum)+" ";
    }else if(numberBeforeLast==0&&number<100){
        output+=getString(lastNum)+" ";
    }
    return output;
}

//This method will return decimal value String representation 
public static String getDecimalValue(String decimal){
    String output="";

    //check whether the decimal string contains fractions
    if(decimal.contains(".")){

        //Identify the fraction and non fraction parts in decimal
        String partBeforeDecimalPoint=decimal.split("\\.")[0];
        String partAfterDecimalPoint=decimal.split("\\.")[1];

        if(partBeforeDecimalPoint.length()>0)
            output=getWholeWord(Integer.parseInt(partBeforeDecimalPoint));

        if(partAfterDecimalPoint.length()>0)
            output+= ((output.length()>0?" and ":"")+getWholeWord(Integer.parseInt(partAfterDecimalPoint))+"cents");

    }else{
        output=getWholeWord(Integer.parseInt(decimal));
    }
    return output; 
}

public static void main(String[] args) {

    System.out.println(getDecimalValue("12.20"));
    System.out.println(getDecimalValue("2100.99"));
    System.out.println(getDecimalValue("4500.67"));
    System.out.println(getDecimalValue("23450"));
    System.out.println(getDecimalValue("15"));

}
}