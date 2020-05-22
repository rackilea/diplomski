public class FilebasedSignaturePolicyProvider implements  SignaturePolicyDocumentProvider {

    @Override
    public InputStream getSignaturePolicyDocumentStream(ObjectIdentifier sigPolicyId) {
        String oid = sigPolicyId.getIdentifier();

        try {
            return new FileInputStream("directory-to-my-policy-files/" + oid);
        } catch (FileNotFoundException e) {
            // handle error
        }
    }
}