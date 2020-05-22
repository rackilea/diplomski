public class InternalVo {

    private int endToEndId;
    private int instdAmt;
    private int mndtId;
    private String dtOfSgntr;
    private boolean amdmntInd;
    private String bIC;
    private String nm;
    private String iBAN;
    private String ccy;


    public InternalVo() {
        super();
    }



    public InternalVo(int endToEndId, int instdAmt, int mndtId, String dtOfSgntr, boolean amdmntInd, String bIC, String nm,
            String iBAN,String ccy) {
        super();
        this.endToEndId = endToEndId;
        this.instdAmt = instdAmt;
        this.mndtId = mndtId;
        this.dtOfSgntr = dtOfSgntr;
        this.amdmntInd = amdmntInd;
        this.bIC = bIC;
        this.nm = nm;
        this.iBAN = iBAN;
        this.ccy = ccy;
    }



    public int getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(int endToEndId) {
        this.endToEndId = endToEndId;
    }

    public int getInstdAmt() {
        return instdAmt;
    }

    public void setInstdAmt(int instdAmt) {
        this.instdAmt = instdAmt;
    }

    public int getMndtId() {
        return mndtId;
    }

    public void setMndtId(int mndtId) {
        this.mndtId = mndtId;
    }

    public String getDtOfSgntr() {
        return dtOfSgntr;
    }

    public void setDtOfSgntr(String dtOfSgntr) {
        this.dtOfSgntr = dtOfSgntr;
    }

    public boolean isAmdmntInd() {
        return amdmntInd;
    }

    public void setAmdmntInd(boolean amdmntInd) {
        this.amdmntInd = amdmntInd;
    }

    public String getbIC() {
        return bIC;
    }

    public void setbIC(String bIC) {
        this.bIC = bIC;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getiBAN() {
        return iBAN;
    }

    public void setiBAN(String iBAN) {
        this.iBAN = iBAN;
    }

    public String getCcy() {
        return ccy;
    }



    public void setCcy(String ccy) {
        this.ccy = ccy;
    }