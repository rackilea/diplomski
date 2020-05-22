public class BrokerTestMain {
    public static void main(String... args) {
        Broker broker = new Broker();
        broker.add(new Component());

        broker.publish("Hello");
        broker.publish(new Date());
        broker.publish(3.1415);
    }
}

class Component {
    @Subscription
    public void onString(String s) {
        System.out.println("String - " + s);
    }

    @Subscription
    public void onDate(Date d) {
        System.out.println("Date - " + d);
    }

    @Subscription
    public void onDouble(Double d) {
        System.out.println("Double - " + d);
    }
}