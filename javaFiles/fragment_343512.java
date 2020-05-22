public static void main(String[] args) {
    BankModel model = new BankModel();
    model.addPerson(new BankPerson("LastName1", "FirstName1", "id1"));
    model.addPerson(new BankPerson("LastName2", "FirstName2", "id2"));
    BankView view = new BankView();
    BankController controller = new BankController(model, view);
    controller.displayGui();
}