public void addProduct(String name, String drink)
{ 
int max = 0;
Scanner y = null;
try{
y = new Scanner(new File("C:\\Users\\فاطمة\\Downloads\\products.txt"));
while(y.hasNext())
{
int a = y.nextInt(); // id
String b = y.next(); // name
String c = y.next(); // drink
max = a;
}
y.close();
}
catch(Exception e)
{
e.printStackTrace();
}
Formatter x = null;
try{
FileWriter f = new FileWriter("C:\\Users\\فاطمة\\Downloads\\products.txt", true);
x = new Formatter(f);
x.format("%d %s %s%n",++max,name,drink);
x.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}