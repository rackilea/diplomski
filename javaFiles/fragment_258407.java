List<FinalObject> finalObjects = Stream.of(dummyObject).flatMap(dummyObj -> dummyObj.getPhoneNumbers().stream()
  .flatMap(phoneNumber -> dummyObj.getAddress().stream()
    .flatMap(addressObject -> addressObject.getFreeTexts().stream()
      .flatMap(freeText -> addressObject.getFamilyMembers().stream()
        .map(familyMember -> new FinalObject(dummyObject.getName(), phoneNumber, freeText,
          addressObject.getHouseNumber(), addressObject.getPinCode(), familyMember.getMemberName(),
          familyMember.getMemberConnection(), familyMember.getMemberPhoneNumber()))
      )
    )
  )).collect(Collectors.toList());