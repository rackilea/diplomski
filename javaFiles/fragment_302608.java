public HomePage(final PageParameters parameters) {

   if(someConditionToHidePage) {
      throw new AbortWithHttpErrorCodeException(404, "page not found");
   }
}