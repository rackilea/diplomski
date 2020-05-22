public static void main (String[] args) throws java.lang.Exception
{
    String ara = "۲۰۱۵-۱۱-۰۲ ۱۸:۴۴:۳۴+۰۰:۰۰";
    for (Locale aLocale : DateFormat.getAvailableLocales()) {
        //Just to save time, not needed.
        if(aLocale.getLanguage() != "ar") continue;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss+SS:SS", aLocale);
            System.out.println(sdf.parse( ara ));
        }
        catch(Exception e){
            System.out.println("locale " + aLocale.toString() + " error");
        }
    }
}