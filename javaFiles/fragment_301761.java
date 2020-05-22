public class Thing {

    private String  operator;
    private void getUserInput(){
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            System.out.println("i have entered integer : " + input.nextInt());
        }else {
            setOperator(input.nextLine());
            addOperators();
            System.out.println("i have entered string : " + getOperator());
        }
        displayThing();
    }
    private ArrayList<String> addOperators(){
        ArrayList<String> operatorsList = new ArrayList<String>();

        if(getOperator().equals("+")){
            operatorsList.add(operator);
        }
        if(getOperator().equals("-")){
            operatorsList.add(operator);
        }
        else{
            operatorsList.add(getOperator());
        }
        return operatorsList;
    }
    private void displayThing(){
        System.out.println(addOperators());
    }    
    public static void main(String[] args) {
        Thing program = new Thing();
        program.getUserInput();       
    }
    //setters and getters
    private void setOperator(String operator){
        this.operator = operator;
    }
    private String getOperator(){
        return this.operator;
    }
}