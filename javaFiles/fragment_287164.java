int count = 0;
for (int run = 0; run<numberOfRecordsInFile; run++)
{
    Record readone = (Record) objinputStream2.readObject();
    System.out.print(readone); 
    System.out.println("");
    count++;
}
System.out.println("Reading completed for all" + count + " records. ");