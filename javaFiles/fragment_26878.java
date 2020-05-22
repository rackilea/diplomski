public verify(String hostYouAreAfter, X509Certificate certYouActuallyGet) {
    if (certYouActuallyGet.equals(referenceCertificate)) {
         if ("server4.company.com".equalsIgnoreCase(hostYouAreAfter)) {
             // All good, don't fail and throw an exception.
         } else {
             super.verify(hostYouAreAfter, certYouActuallyGet);
         }
    } else {
         super.verify(hostYouAreAfter, certYouActuallyGet);
    }
}