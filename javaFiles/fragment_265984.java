public class MyClassTest {

    private MyClass myclass;

    @Test
    public void testmyFunc() {
        // prepare map
        Map<String, Manager> managerMap = new HashMap();
        MyManager1 = myManager new MyManager1()
        managerMap.put(myObj.getClass.getName(), myManager);

        // create class under test with injected map
        myclass = new MyClass(managerMap);

        myclass.myFunc(myManager);
    }
}