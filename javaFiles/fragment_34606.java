List<UserData> userDataList =
    phoneNumbers.stream()
                .filter(p -> p.getPrimary()) // or filter(ClassName::getPrimary)
                .map(p -> {
                         UserData userData = new UserData();
                         userData.setDescription(p.getType());
                         userData.setValue(p.getNumber());
                         return userData;
                         })
                .collect(Collectors.toList());