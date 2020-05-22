public interface INotification
{
        Object getObject();

        Object getPropertyId();
}

public class Notification implements INotification
{
        private final Object object;
        private final Object propertyId;

        public Notification(Object object, Object propertyId)
        {
                this.object = object;
                this.propertyId = propertyId;
        }

        @Override
        public Object getObject()
        {
                return object;
        }

        @Override
        public Object getPropertyId()
        {
                return propertyId;
        }
}