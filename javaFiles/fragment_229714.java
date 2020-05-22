int maxAttempts = 3;
for(int attempts = 0; attempts < maxAttempts; attempts++) {
    try {
         connect = new LDAPConnection(...);
         /*if connection can be established then break from loop, but keep connection alive*/
         break;
    } catch(LDAPException exc) {
         if(attempt == (maxAttempts-1)) {
             //throw exception message
             throw exc;
         }
    }
    Thread.sleep(1000);
}