@Page(path = "MyPath")
public class EventDesignDialog implements IEventDesignDialog{
        @Entity(visibileName = "Show")
        public IEventDesignDialog getShow() {
            System.out.println("get show method invokde successfully");
            return getProxyInstance();
        }

        @Entity(visibileName = "Date And Time display format")
        public IEventDesignDialog getDateAndTimeDisplayFormat() {
            System.out.println("get date and time display format method invokde successfully");
            return getProxyInstance();
        }

        @Entity(visibileName = "Event Type")
        public IEventDesignDialog getEventType() {
            System.out.println("get event type method invokde successfully");
            return getProxyInstance();
        }
}