public class LeadDetailsSRO {
    private String emailId;
    private String emailByCompany;
    private int level;
    private String alternateNumber;
    private String languagePreference;
    private String kycName;
    private String businessAs;
    private String aadharName;
    private String panName;
    private String ovdName;
    private String kycStatus;
    private String aadhaarStatus;
    private String panStatus;
    private Set<String> ownershipTypeSet;
    private String empId;
    private String designation;
    private Boolean nameMatchSuccess = null;
    private String isSIMandatory;

    public void deleteFields(List<String> fields) {
        for (String fieldName : fields) {
            switch (fieldName) {
            case "emailId":
                this.emailId = null;
                break;
            case "emailByCompany":
                this.emailByCompany = null;
                break;
            // ...
            }
        }
    }
}