public void InsertNewEmployee(String firstName, String lastName, int id){
    try {
        employee[numOfItems] = new Employee(firstName, lastName, id);
        numOfItems++;
    }
    catch (Exception e) {
        System.out.println(e.toString());
    }