class Person implements IObservable
{
        private final IObservable observable = new Observable();

        @Override
        public void setFirstName(String firstName) throws Exception
        {
            if (firstName == null || firstName.isEmpty())
            {
                    throw new Exception("First name not set");
            }

            this.firstName = firstName;
            notifyObservers(new Notification(this, getFirstNamePropertyId()));
        }

    @Override
    public void addObserver(IObserver o)
    {
            observable.addObserver(o);
    }

    @Override
    public void deleteObserver(IObserver o)
    {
            observable.deleteObserver(o);
    }

    @Override
    public void notifyObservers(INotification notification)
    {
            observable.notifyObservers(notification);
    }

    private static final String FIRSTNAME_PROPERTY_ID = "Person.FirstName";

    @Override
    public String getFirstNamePropertyId()
    {
            return FIRSTNAME_PROPERTY_ID;
    }

}