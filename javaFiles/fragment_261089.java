public void output2()
{
    int remainder = change; //make a copy of change variable so it remains final.
    int count=0;
    System.out.println("Your change is");
    if(remainder>=100){
        hundred = (int)remainder/100;
        remainder %= 100;
    }
    if(remainder>=50){
        fifty = (int)remainder/50;
        remainder %= 50;
    }
    if(remainder>=20){
        twenty = (int)remainder/20;
        remainder %= 20;
    }
    ...
    System.out.print(hundred + " one hundred dollar bills,");
    System.out.print(fifty + " fifty dollar bills,");
    System.out.print(twenty + " twenty dollar bills,");
    ...
}