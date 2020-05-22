@Override
    public Person getPerson(int id) {
        Person personForId = person.get(id);
        if (personForId == null) {
          thrown new NotFoundException();
        }
        return personForId;
    }