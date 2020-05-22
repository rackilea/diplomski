MapVerifier verifier = new MapVerifier();
NewAwsVerifier newVerifier = new NewAwsVerifier(verifier);

// Get passwords from a more secure source (only here for illustration)!
verifier.getLocalSecrets().put("accessKey", "secretKey".toCharArray());
auth.setVerifier(newVerifier);