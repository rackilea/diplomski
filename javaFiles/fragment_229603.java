static class ResponseUserDetails {
   final Response response;
   final UserDetails userDetails;

   ResponseUserDetails(
            final Response response,
            final UserDetails userDetails) {
      this.response = response;
      this.userDetails = userDetails;
   }

   static ResponseUserDetails of(
            final Response response,
            final UserDetails userDetails) {
      return new ResponseUserDetails(response, userDetails);
   }
}