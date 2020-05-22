public boolean doesIDExist(ArrayList<? extends RegistrationSystem> array, int id){
    boolean exist = false;
    for (RegistrationSystem array1 : array) {
        if (array1.getId() == id) {
            exist = true;
            break;
        }
    }
    return exist;
}