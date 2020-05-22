public enum FlagOfficer {
    // Enum instances/values should be declared first.
    // Use INSTANCE(arg1, ..) if constructor accepts agruments.
    INSTANCE; 

    // Constructor can accept arguments as well.
    private FlagOfficer() {

    }

    private Date lastBackupDate;
    private boolean syncProcessStartedOnce;

    public Date getLastBackupDate() {
        return lastBackupDate;
    }

    public boolean isSyncProcessStartedOnce() {
        return syncProcessStartedOnce;
    }
 }