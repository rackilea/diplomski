public class MiddleVo {

    private String svcLvlCD;
    private String lclInstrmCD;
    private int seqTp;
    private String reqdColltnDt;
    private String nm;
    private String iBAN;
    private String bIC;

    public MiddleVo() {
        super();

    }

    public MiddleVo(String svcLvlCD, String lclInstrmCD, int seqTp, String reqdColltnDt, String nm, String iBAN,
            String bIC) {
        super();
        this.svcLvlCD = svcLvlCD;
        this.lclInstrmCD = lclInstrmCD;
        this.seqTp = seqTp;
        this.reqdColltnDt = reqdColltnDt;
        this.nm = nm;
        this.iBAN = iBAN;
        this.bIC = bIC;
    }

    public String getSvcLvlCD() {
        return svcLvlCD;
    }

    public void setSvcLvlCD(String svcLvlCD) {
        this.svcLvlCD = svcLvlCD;
    }

    public String getLclInstrmCD() {
        return lclInstrmCD;
    }

    public void setLclInstrmCD(String lclInstrmCD) {
        this.lclInstrmCD = lclInstrmCD;
    }

    public int getSeqTp() {
        return seqTp;
    }

    public void setSeqTp(int seqTp) {
        this.seqTp = seqTp;
    }

    public String getReqdColltnDt() {
        return reqdColltnDt;
    }

    public void setReqdColltnDt(String reqdColltnDt) {
        this.reqdColltnDt = reqdColltnDt;
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

    public String getbIC() {
        return bIC;
    }

    public void setbIC(String bIC) {
        this.bIC = bIC;
    }

}