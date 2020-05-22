ExternalFile readJSON = null; //--> you have not intialized readJSON 
try
{
     result = readJSON.readFile(REFERENCE_DIRECTORY, "contacts.json");
              ^^^^^^^^
              null access here