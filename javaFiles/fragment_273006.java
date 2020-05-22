Locale[] locales = Locale.getAvailableLocales();
   String cCode;
   for (Locale loc :locales){
       cCode = loc.getCountry();
       if (cCode.equalsIgnoreCase("MK"))
            Toast.makeText(this, cCode, Toast.LENGTH_SHORT).show();
        // Or System.out.println() in a Java app    
}