class NullHostKeyVerifier implements HostKeyVerifier {
    @Override
    public boolean verify(String arg0, int arg1, PublicKey arg2) {
        return true;
    }        
}