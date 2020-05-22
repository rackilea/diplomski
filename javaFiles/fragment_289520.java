String any; //Change any from type char to String
double b;
double c;
double n;

System.out.print("Input character(s): ");
any = kets.next(); 
//Retrieve just the next() String..no need to delve deeper for a character.
System.out.print("Input range: ");
n = Integer.parseInt(reader.readLine());

for(b=1; b<=n; b++)
{
    for(c=1; c<=b; c++)
    {
        System.out.print(any);
    }
    System.out.println();
}