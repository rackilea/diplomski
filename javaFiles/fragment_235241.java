exportables.get(0).getCSVHeaderMap(currentUser).keySet().stream().
map(s -> {
            String result;//Put the class to which you map
            if(null == s)// Some condition that you want to check.
            {
                //get info from another place
                //result = ....
            }
            else
            {
                result = messageSource.getMessage("report."+s, null, locale);
            }
            return result;
         }
   ).toArray(String[]::new);