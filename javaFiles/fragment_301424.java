RealmQuery<Machine> query = realm.where(Machine.class);
for (int i = 0; i < machineIds.size(); i++){
    if (i != 0) query = query.or();
    query = query.equalTo("id", machineIds.get(i));
}
RealmResults<Machine> machines = query.findAll();