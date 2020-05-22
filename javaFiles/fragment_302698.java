boolean chkOilLevel(){
Scanner Console = new Scanner(System.in);
//Questions here

System.out.print("Wheel alingment (%)? ");
wheelAliResult = Console.nextInt();

if(wheelAliResult < 0 || wheelAliResult > 6)
{
    wheelResult = true;
}
else
{
    wheelResult = false;
}
return wheelResult;
}