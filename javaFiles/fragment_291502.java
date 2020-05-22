import org.junit.Assert;

public class ClassNameTest {

    public void testMethod1() {
        ArrayList<Order> list1 = new ArrayList<>();
        ArrayList<Order> list2 = new ArrayList<>();
        Order order = new Order();
        ClassName testMe = new ClassName(list1, list2);
        testMe.method1(order);
        // Insert your assertions for example:
        Assert.assertTrue(list1.contains(order));
    }

}