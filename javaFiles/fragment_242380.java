public class PaneWithNFCReader extends OwnPane {
    @Override
    public void setAsRoot(){
         super.setAsRoot();
         activateNFCThread();
    }
}