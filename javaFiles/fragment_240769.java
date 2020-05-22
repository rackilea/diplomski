String DELIMITER = ",";
int FIELD_TO_SUM = 3;
int sum = 0;
int lineCount = 0;
BufferedReader reader = new BufferedReader(new FileReader("/path/to/file.csv"));
String line = null;
boolean firstTime = true;
while ((line = reader.readLine()) != null) {
   String[] split = line.split(DELIMITER);

   if (firstTime) {
       firstTime = false;
       // do somethign spetial for the header
       continue;
   }
   lineCount++;
   sum = sum + Integer.parseInt(split[FIELD_TO_SUM-1]);
}

System.out.println("Line count: "+ lineCount);
System.out.println("Sum of field "+FIELD_TO_SUM+": "+ sum);+ sum);