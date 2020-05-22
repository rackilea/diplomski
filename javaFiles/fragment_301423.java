public class Factory {
    RealmList<Machine> machineList;
    // setter & getters
}

Factory factory = new Factory();
RealmList<Machine> machineList = new RealmList<>();
// Add something to the list
factory.setMachines(machineList);
realm.beginTransaction();
Factory managedFactory = realm.copyToRealmOrUpdate(factory);
realm.commitTransaction();