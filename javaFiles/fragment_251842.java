private Matcher<S3Bucket> bucketName(final String expected) {
  return new FeatureMatcher<S3Bucket, String>(equalTo(expected), 
                                              "bucket called", "name") {
     String featureValueOf(S3Bucket actual) {
       return actual.getName();
     }
  };
}