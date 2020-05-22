String[] emails = { "test@test.com;test2@test.com;test3@test.com", "test@test.com"  };
List<string> result = new ArrayList<String>();

for ( string listOfEmails : emails ) {
  for( string email : listOfEmails.split(";") ) {
    result.Add(email).
  }
}

System.out.println(result);