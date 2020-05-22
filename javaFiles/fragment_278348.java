public void series()
{
    sum=1.0;
    double fact=1.0;
    for(int a=2;a<=n;a++)
    {
        for(int b=a;b>0;b--)
            fact=fact*b;

        double c=a/fact;
        double newValue = Math.pow(x,c); // line changed

        if(a%2==0)
            newValue = -newValue; // sign calculation

        values.add(newValue);     // save the value
        sum += newValue;          // now add
        fact=1;
    }
}

//and it's also easy to display the values:
public void display()
{
    System.out.println("The sum of the series is " +sum);
    System.out.println("The members of the series are: ");
    String str = "";
    for(Double d : values){
        str += d+", ";
    }
    str = str.substring(0,str.length()-2);//remove the last ","
    System.out.println(str);
}