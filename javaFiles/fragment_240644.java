ContentVerifierProvider contentVerifierProvider =
   new BcRSAContentVerifierProviderBuilder(
      new DefaultDigestAlgorithmIdentifierFinder()).build(lwPubKey);

if (!certHolder.isSignatureValid(contentVerifierProvider))
{
    System.err.println("signature invalid");
}