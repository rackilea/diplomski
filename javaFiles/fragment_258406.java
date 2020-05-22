List<FinalObject> finalObjects = new ArrayList<>();
for(String phoneNumber : dummyObject.getPhoneNumbers()) {
  for(AddressObject addressObject : dummyObject.getAddress()) {
    for (String freeText : addressObject.getFreeTexts()) {
      for (FamilyMember familyMember : addressObject.getFamilyMembers()) {
        finalObjects.add(new FinalObject(dummyObject.getName(), phoneNumber, 
          freeText, addressObject.getHouseNumber(), addressObject.getPinCode(), 
          familyMember.getMemberName(), familyMember.getMemberConnection(), 
          familyMember.getMemberPhoneNumber()));
      }
    }
  }
}