PrivateObject privateObject = new PrivateObject("The Private Value");

Field privateStringField = PrivateObject.class.
        getDeclaredField("privateString");

privateStringField.setAccessible(true);

String fieldValue = (String) privateStringField.get(privateObject);
System.out.println("fieldValue = " + fieldValue);