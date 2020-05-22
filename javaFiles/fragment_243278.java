Scanner scan = new Scanner(new File("yourfile"));
ArrayList<String[]> records = new ArrayList<String[]>();
String[] record = new String[2];
while(scan.hasNext())
{
    record = scan.nextLine().split(",");
    records.add(record);
}
//now records has your records.
//here is a way to loop through the records (process)
    for(String[] temp : records)
    {
        for(String temp1 : temp)
        {
            System.out.print(temp1 + " ");
        }
        System.out.print("\n");
    }