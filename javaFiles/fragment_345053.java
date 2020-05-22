List raw = new ArrayList();
raw.add ("some string");
YourFormClass form = new YourFormClass ();
form.setIdProviders (raw);
...
List<Long> idProviders = form.getIdProviders();
for(Long idProvider: idProviders) { // here an attempt is made to cast a String 
                                    // to a Long leading to ClassCastException
    ....
}