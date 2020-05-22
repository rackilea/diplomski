@Test
public void test_scan() throws Exception
{
Myclass myobject=new myobject(); // with args

myobject.load(filename); // you must definie the filename

String result=myobject.scaninput_and_compare(); // you must use scan in, and compare

if (!result.equals(what_I_am_expecting) throw new Exception("EXCEPTION scaninput_and_compare"); 

// If you arrive here, it's OK
}