if(countryES)
{
    //Change local to es_ES
   Locale localeEs = new Locale("es");
                Locale.setDefault(localeEs);
                Configuration configEs = new Configuration();
                configEs.locale = localeEs;
                getBaseContext().getResources().updateConfiguration(configEs, getBaseContext().getResources().getDisplayMetrics());
} 
else
{
     //Change local to en_US
   Locale localeEs = new Locale("en");
                Locale.setDefault(localeEs);
                Configuration configEs = new Configuration();
                configEs.locale = localeEs;
                getBaseContext().getResources().updateConfiguration(configEs, getBaseContext().getResources().getDisplayMetrics());
}