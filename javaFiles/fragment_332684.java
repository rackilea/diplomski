DBCollection collec1 = database.getCollection("coll"); 
for( DBObject dock : collec1.find() ) {
    String name = (String) dock.get( "Name" );
    String address = (String) dock.get( "Address" );
    String mobileNumber = (String) dock.get( "MobileNumber" );

    // Do Something...
}