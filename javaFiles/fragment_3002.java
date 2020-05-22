public void deleteContact(String name)
        {
          for ( int i = 0; i <= numContacts-1; i++){
            if(  name.equals( myContacts[i].getName()))// string comparison uses equals();
            {
             myContacts[i] = null;
                numContacts--;  // this line should be inside of if condition 
               break; 
            }
            // break; No need of breaking the loop here
          }
        }