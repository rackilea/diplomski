public class MyCustomStringTest { 
    private MyCustomStringInterface mycustomstring;

    @Test
    public void testCountNumbers1() {
    mycustomstring = new MyCustomString();
       mycustomstring.setString("th1s strin8 shou1d hav3 numb3rs, righ7?");

       assertEquals(6, mycustomstring.countNumbers());
    }   
}