ObjectModel objectModel = new ObjectModel();
     objectModel.setMobile_number("123456789");
     objectModel.setWork_number("12345789");
     objectModel.setFax_number("123465");
     objectModel.setFirst_name("first name");
     objectModel.setLast_name("last name");
     objectModel.setWebsite("ww.solution.com");

    ArrayList<ObjectModel.Email> emails = new ArrayList<>();
    ObjectModel.Email email = new ObjectModel.Email();
    email.setPersonal("abc@gmail.com");
    email.setWork("work@gmail.com");
    emails.add(email);

    objectModel.setEmail(emails);

    Gson gson = new Gson();
    String strJsonObject = gson.toJson(objectModel);
    Log.e("strJsonObject", strJsonObject);