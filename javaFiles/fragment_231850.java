String string =
"<ns2:sendGetResponse xmlns:ns2='http://test.com/bt/' xmlns:SOAP-   \r\n" +
"ENV='http://schemas.xmlsoap.org/soap/envelope/' \r\n" +
"xmlns:xs='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-    instance'><return> \r\n" +
"  [{\"Id\":30477,\"EmailAddress\":\"truech@abc.com\",\"FirstName\":\"abc\",\"LastName\":\"xyz\",\"MiddleNam    e\":\"H\",\"MaidenName\":null,\"OtherNames\":null,\"RaceCode\":\"A           }]   \r\n" +
"</return></ns2:sendGetResponse>";

System.out.println( string.split("</?return>")[1] );