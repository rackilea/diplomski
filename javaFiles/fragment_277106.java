ComplexJacksonObject cjo = new ComplexJacksonObject();
cjo.Count = 1;
cjo.Start = 2;
cjo.Strings = new ArrayList<String>();
cjo.Strings.add("One");
cjo.Strings.add("Two");

cjo.MyPerson = cjo.new Person();
cjo.MyPerson.Firstname = "Fi\",=[]{}rst";
cjo.MyPerson.Lastname = "Last";

cjo.MyPerson.Where = cjo.new Address();
cjo.MyPerson.Where.Street = "Street";
cjo.MyPerson.Where.Number = 15;

String result = cjo.toQueryString();        
// Strings=%5B%22One%22%2C%22Two%22%5D&MyPerson=%7BFirstname%3A"Fi%5C%5C%22%2C%3D%5B%5D%7B%7Drst"%2CLastname%3A%22Last%22%2CWhere%3A%7BStreet%3A%22Street%22%2CNumber%3A15%7D%7D&Start=2&Count=1