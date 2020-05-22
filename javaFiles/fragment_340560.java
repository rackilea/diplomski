SignedInfo si = fac.newSignedInfo
                      (fac.newCanonicalizationMethod
                        (CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
                          (C14NMethodParameterSpec) null),
                        fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                        Collections.singletonList(ref));