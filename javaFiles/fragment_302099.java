public void print(String fName , String sName) throws Exception {
    Field fNameField = this.getClass().getDeclaredField(fName);
    Field sNameField = this.getClass().getDeclaredField(sName);
    System.out.println(fNameField.get(this));
    System.out.println(sNameField.get(this));
}