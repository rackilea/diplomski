setModel(new CompoundPropertyModel(person));
add(new TextField("spouse.familyName"));
add(new TextField("children[0].age"));
add(new Link<Person>("delete") {
    @Override
    public void onClick() {
        Person p = getModelObject();
        if(p.isUnderage()) {
            p.delete();
        }
    }
});