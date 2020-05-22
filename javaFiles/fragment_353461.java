void updateData() {
    myApi.insertNewGroup(modelGroup.getName(), modelGroup.getRating()) //Creating new group and getting its ID
            .switchMap(this::setGroupIdAll) //Calling observable that will loop thru all persons and set their groupIDs
            .subscribe(
                    (n) -> {/*you will get String after every 'insertNewPerson' run*/},
                    (e) -> {/*error handling*/}
            );

}

Observable<String> setGroupIdAll(Integer id) {
    return Observable.fromIterable(personsIterable) //personsIterable contains all your ModelPerson objects
            .flatMap(this::updatePerson); //Call Observabl;e that will send updated person to the server
}

Observable<String> updatePerson(ModelPerson person) {
    return myApi.insertNewPerson(
            person.getGroup_id(),
            person.getFirst_Name(),
            person.getLast_Name());
}