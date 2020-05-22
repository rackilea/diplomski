private static class CalendarScheduleUpdatedEventListener extends ScheduleUpdatedEventListener.Stub {
    final WeakReference<Object> obj; //change <Object> to whatever type it is.

    CalendarScheduleUpdatedEventListener(Object x) {
        this.obj = new WeakReference<>(x);
    }

    @Override
    public void onScheduleUpdatedEvent() throws RemoteException {
        Object o = obj.get();
        if (o == null) {
            //because a WeakReference will be null if it has been garbage collected.
            return; //or throw some exception
        }
        o.updateCalendar();
    }
}