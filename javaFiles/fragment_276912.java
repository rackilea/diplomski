Scanner keyboard = new Scanner(System.in);
String exp = keyboard.next();
    String []all = exp.split(" ", -1);
/*
then
all[0] = first operation;
all[1] = operator;
all[0] = second operator
*/

//and you can do like this
void calculate(String []all) {

    Double value1 = Double.parseDouble(all[0]);
    Double value2 = Double.parseDouble(all[2]);
    String op = all[1];

     if(op.equals("+")){
            System.out.println(value1 + value2);

    }if(op.equals("-")){
        System.out.println(value1 - value2);

    }if(op.equals("/")){
        System.out.println(value1 / value2);

    }if(op.equals("*")){
        System.out.println(value1 * value2);

    }if(op.equals("^")){
        System.out.println(Math.pow(value1, value2));

    }if (op.equals("log")){
        System.out.println(Math.log(value1));

    }else{

    }  
}