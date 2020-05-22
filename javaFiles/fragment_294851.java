for(int i=0;i<row;i++)
{
    String record[] = list.get(i).split(",");
    String num = record[1];
    if(searchnum.equals(num))
    {
            found = true;
            System.out.println("\t\t\t*******************************");
            System.out.println("\n\t\t\t---------RECORD FOUND----------");
            System.out.println("\n\t\t\tProduct Number      : "+record[0]);
            System.out.println("\t\t\tCategory              : "+record[1]);
            System.out.println("\t\t\tProduct Name          : "+record[2]);
            System.out.println("\t\t\tPrice                 : "+record[3]);
            System.out.println("\t\t\tQuantity              : "+record[4]);
            System.out.println("\n\t\t\t*******************************");
            Thread.sleep(2000);
    }

}

System.out.println("\n\n\t\t\tSearch Completed");
if(found == false)
{
        System.out.println("\t\t\tNo Record Found");
        System.out.println("\t\t\t*******************************");
}
exiting();