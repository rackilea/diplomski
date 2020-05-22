/* This creates an entry in the form HPD:Help Desk, returns the Entry ID (not Incident Number) to the command line */

import com.bmc.arsys.api.*;

public class CreateEntry {

public static void main(String[] args) {

//Initialize a new ARServerUser object, this is the main object we are using for all actions

// for e.g. user=Demo, password=pwd, server=remedy, port=7100

ARServerUser context = new ARServerUser("Demo", "pwd", "", "","remedy",7100);

//A new entry we want to submit into remedy

Entry newEntry = new Entry();

//put the field values in there. (Integer fieldID, Value of field)

newEntry.put(7, new Value(0));          // Status<br>
newEntry.put(8, new Value("This record is created via Java API"));  // Short Description<br>
newEntry.put(1000000163, new Value(4000));  // Impact - (High) 1000/2000/3000/4000 (Low)<br>
newEntry.put(1000000162, new Value(4000));  // Urgency - (High) 1000/2000/3000/4000 (Low)<br>
newEntry.put(1000000000, new Value("xyz")); // Description<br>
newEntry.put(1000000151, new Value("xyz")); // Details<br>
newEntry.put(1000000099, new Value(0));     // Service Type - 0/1/2/3<br>
newEntry.put(240001002, new Value("xyz"));  // Product Name<br>
newEntry.put(200000003, new Value("xyz"));  // Product Cat Tier 1<br>
newEntry.put(240001002, new Value("xyz"));  // Product Cat Tier 2<br>
newEntry.put(200000005, new Value("xyz"));  // Product Cat Tier 3<br>
newEntry.put(1000000063, new Value("xyz")); // Operational Cat Tier 1<br>
newEntry.put(1000000064, new Value("xyz")); // Operational Cat Tier 2<br>
newEntry.put(1000000217, new Value("xyz")); // Assigned Group<br>
newEntry.put(1000000054, new Value("xyz")); // Corporate ID<br>
newEntry.put(2, new Value("Demo"));<br>

try{

//And here we create the entry itself, printing out the EntryID we get back

String EntryId = context.createEntry("HPD:Help Desk", newEntry);

System.out.println("Request ID = "+EntryId);

}

catch(ARException arException){

arException.printStackTrace();

}

}

}