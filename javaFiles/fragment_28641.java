// Create the list that shall contains the read properties
List<GetReminder> reminders = new ArrayList<>();

SoapObject obj=(SoapObject)envelope.getResponse(); 
Log.d("Result --ddd- ", obj.toString() ); 
System.out.println("obj---->" + obj.getPropertyCount()); 

for(int i=0; i < obj.getPropertyCount(); i++) {
   System.out.println("here i is.........." +i);

   // Create a new instance
   GetReminder rem = new GetReminder();

   // Read and set the fields values of rem
   KSoap2ResultParser.parseBusinessObject(obj.getProperty(i).toString(), rem); 

   // Don't forget to store the new reminder in the list
   reminders.add(rem);
}   

// Do what you want with the list of reminders