public String scaninput_and_compare(String filename)
{
Scanner Input = new Scanner(System.in);
String name = Input.nextLine();

BufferedReader br;
 try{
   br = new BufferedReader(new FileReader(new File(filename)));
   String nextLine;
   while ((nextLine = br.readLine()) != null)
   {
       if (nextLine.startsWith("||"))
       {
            int f1 = nextLine.indexOf("*");
            int f2 = nextLine.indexOf("_");
            fName = nextLine.substring(f1+1, f2);
               if (name.equals(fname))
               {
                    String[] s1 = nextLine.split("_");
                    String sName = s1[1];
                    return sName;
               }
       }
   }
// NO GOOD
return "lose";
}


@Test
public void test_scan() throws Exception
{
Myclass myobject=new myobject(); // with args

String filename="good_filename";

// MOCK System.in
String data = "Jack";
InputStream stdin = System.in;
System.setIn(new ByteArrayInputStream(data.getBytes()));

String result=myobject.scaninput_and_compare(filename); // you must use scan in, and compare

// RESTABLISH System.in
Scanner scanner = new Scanner(System.in);
System.setIn(stdin);

if (!result.equals("Davis") throw new Exception("EXCEPTION scaninput_and_compare"); 

// If you arrive here, it's OK
}