SoapObject obj=(SoapObject)envelope.getResponse();
int nbProperties = obj.getPropertyCount();

for (int i = 0; i < nbProperties; i++) {
   KSoap2ResultParser.parseBusinessObject(obj.getProperty(i).toString(), getReminder);
   // Do something with getReminder object
}