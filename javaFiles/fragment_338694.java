public class ApplicationServices {
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void setUpdating(boolean b) {
        // update DB here
    }
}