protected String getSetMessage(String attemptedType, String attemptedValue) {
         String err = "Can not set";
         if (Modifier.isStatic(field.getModifiers()))
             err += " static";
         if (isFinal)
             err += " final";
         err += " " + field.getType().getName() + " field " + getQualifiedFieldName() + " to ";
         if (attemptedValue.length() > 0) {
             err += "(" + attemptedType + ")" + attemptedValue;
         } else {
             if (attemptedType.length() > 0)
                 err += attemptedType;
             else
                 err += "null value";
         }
         return err;
     }