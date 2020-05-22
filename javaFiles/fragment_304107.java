GoogleApiClient client = new GoogleApiClient.Builder(this)
         .addApi(Plus.API)
         .addScope(Plus.SCOPE_PLUS_LOGIN)
         .setAccountName("users.account.name@gmail.com")
         .build();


client.connect();
Person.Gender gender;
Person personProfile = Plus.PeopleApi.getCurrentPerson(client);

if (person.hasGender()) // it's not guaranteed
          gender = person.getGender();