public enum RSVP {
    APPLIED_REJECTED, 
    APPLIED_SHORTLISTED, 
    SHORTLISTED_SELECTED, 
    SHORTLISTED_IN_PROGRESS, 
    SHORTLISTED_ON_HOLD, 
    SHORTLISTED_REJECTED;

    private int status;

    public int getValue() {
        return status;
    }
}