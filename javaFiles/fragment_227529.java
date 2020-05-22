public void setMediaToDefault(){
    String defaultCountry = Locale.getDefault().getCountry();
    if (defaultCountry != null &&
        (defaultCountry.equals(Locale.US.getCountry()) ||
         defaultCountry.equals(Locale.CANADA.getCountry()))) {
        setMedia(MediaType.NA_LETTER);
    } else {
        setMedia(MediaType.ISO_A4);
    }
}