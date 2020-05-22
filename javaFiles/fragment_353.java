int number = 0;

do
{
    number = reader.nextInt();

    if (number>0)
    {
        sum+=number;
        list++;
    }
    else if (number<0)  
    {
        System.out.println("ERROR type in a postive integer");

    }

}while (number!=0);
reader.close();