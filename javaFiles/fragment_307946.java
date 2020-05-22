@Router(inputChannel="persistingAndNotifyingCustomerChannel")
public String[] route(Object payload) {
   return Arrays.AsList("persistingChannel", "notifyingCutomerChannel");
}

@ServiceActivator(inputChannel = "persistingChannel")
public void persist(Object payload) {
    // persist
}

@ServiceActivator(inputChannel = "notifyingCutomerChannel")
public void notify(Object payload) {
    // notify
}