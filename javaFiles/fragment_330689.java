Class<?> getProviderClass(String customerType) {
     switch (customerType) {
          case "FACEBOOK":{
               return FacebookApi.class;
          }
          case "GOOGLE":{
               return GoogleApi20.class;
          }
          default: return null;
      }
 }