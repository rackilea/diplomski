LanguageTest lt = new LanguageTest();
 System.out.println(lt.getGreeting());

 private class LanguageTest{
    String lang = Locale.getDefault().getLanguage().toLowerCase();

    public String getGreeting(){
        return (lang.contains("fr") ? "Bonjour" : "Hello");
    }

}