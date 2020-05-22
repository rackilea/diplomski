long weight=1;
long finalSum=0;
while(number>0){
    long a=number%10;
    finalSum+=(a*weight);
    weight++;
    number/=10;
}
if((finalSum%11)==10){
    System.out.println("Final sum when divided by 11 gives remainder 10");
}