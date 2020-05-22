switch(operator)
{
    case '+' :
    {
        double addition  = a+b;
        System.out.print("Total after Addition is : "+addition);
        break;
    }
    case '-' :
    {
        double subtraction  = a-b;
        System.out.print("Total after Subtraction is : " +subtraction);
        break;
    }
    case '*' :
    {
        double multiplication  = a*b;
        System.out.print("Total after Multiplication is : "+multiplication);
        break;
    }
    case '/' :
    {
        double division  = a/b;
        System.out.print("Total after Division is : "+division);
        break;
    }
    default :
    {
        System.out.print("Please select proper operator");
        return;
    }
}