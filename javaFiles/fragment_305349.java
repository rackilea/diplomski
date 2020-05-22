LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("File1")));
lnr.skip(Long.MAX_VALUE);

long length = lnr.getLineNumber();

lnr.close();

in = new BufferedReader(new FileReader( "data.txt" ));

Car[] cars= new Car[length/5];
String currentLine;
int i=0;

for(int i=0;i<length/5;i+=5) {
    String name = in.readLine();
    String year = in.readLine();
    String miles = in.readLine();
    String gas = in.readLine();
    String color = in.readLine();
    cars[i] = new Car(name,year,miles,gas,color);
}