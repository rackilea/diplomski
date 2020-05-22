ArrayList<People> list = new ArrayList<>();

// add people to the list
People marie = new People(1, "Bower", "Marie");
list.add(marie);

// Search function
  public String readPeople(int idPeople) {
    People p = null;
    for(int i = 0; i < list.size(); i++) {
        // If equal than it is the result
        if(list.get(i).id == idPeople) {
            p = list.get(i);
            break;
        }
    }
    return p == null ? null : p.getName();
  }