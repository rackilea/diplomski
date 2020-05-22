//Lets print the Employee List
for(int i = 0; i < addressList.size(); i++) {
        address e = addressList.get(i);
        System.out.println("The address details in the index....." + i + "....:" + e.getFirstName()
            + "..." + e.getLastName() + "..." + e.getAdd() + "...." + e.getCit() + ".. " + e.getSt()
            + "..." + e.getZip());

}