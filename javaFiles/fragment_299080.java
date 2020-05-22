if (checkForNull(userParameter, configurationParameter)){
   add.userParameter();
   add.configurationParameter();
 }

 private boolean checkForNull(Object... objects){
    for (Object obj : objects){
        if (obj == null){
            return true;
        }
    }
    return false;
 }