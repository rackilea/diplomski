/**
 * Signs the constructed JWT using the specified algorithm with the specified key, producing a JWS.
 * 
 * <p>This is a convenience method: the string argument is first BASE64-decoded to a byte array and this resulting
 * byte array is used to invoke {@link #signWith(SignatureAlgorithm, byte[])}.</p>
 *
 * @param alg                    the JWS algorithm to use to digitally sign the JWT, thereby producing a JWS.
 * @param base64EncodedSecretKey the BASE64-encoded algorithm-specific signing key to use to digitally sign the
 *                               JWT.
 * @return the builder for method chaining.
 */
JwtBuilder signWith(SignatureAlgorithm alg, String base64EncodedSecretKey);