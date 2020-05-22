exportables.get(0).getCSVHeaderMap(currentUser).keySet().stream().
map(s -> {
            String result;//Put the class to which you map

            try{
                result = messageSource.getMessage("report."+s, null, locale);
              }catch(NoSuchMessageException e){
              // code to work over lacking properties here you have access to s
              }
              return result;
         }
   ).toArray(String[]::new);