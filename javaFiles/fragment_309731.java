//Note that you declare this method static: as such it will have no access to object
//member fields, only to class fields: these are member fields declared 'static'
public static void calculatePrice(){
    Scanner userInput = new Scanner(System.in);//Note this has little to do with actually calculating price.
    int orderNumber;
    double totalBill = 0;//You a declaring a new variable that will disappear once it goes out of the scope of this method

    orderNumber = userInput.nextInt();
    switch(orderNumber){
    case 1:
        totalBill = totalBill + American;
        displayMenu();
        calculatePrice();//Recursive call!
        break;
//... eliding for brevity
    case 0:
        System.out.println("Your total bill will be $"+ totalBill);
        break;
    }
} //this is the point where all method variables go out of scope, because this 'stack frame' is unloaded. Any subsequent call to this method will not 'remember' any state that was not saved elsewhere.