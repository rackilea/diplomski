public class HeaderVo {


    private String msgId;
    private String creDtTm;
    private int nbOfTxs;
    private int ctrlSum;
    private String nm;
    private String id;


    public HeaderVo() {
        super();
    }


    public HeaderVo(String msgId, String creDtTm, int nbOfTxs, int ctrlSum, String nm, String id) {
        super();
        this.msgId = msgId;
        this.creDtTm = creDtTm;
        this.nbOfTxs = nbOfTxs;
        this.ctrlSum = ctrlSum;
        this.nm = nm;
        this.id = id;
    }




    public String getMsgId() {
        return msgId;
    }


    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


    public String getCreDtTm() {
        return creDtTm;
    }


    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }


    public int getNbOfTxs() {
        return nbOfTxs;
    }


    public void setNbOfTxs(int nbOfTxs) {
        this.nbOfTxs = nbOfTxs;
    }


    public int getCtrlSum() {
        return ctrlSum;
    }


    public void setCtrlSum(int ctrlSum) {
        this.ctrlSum = ctrlSum;
    }


    public String getNm() {
        return nm;
    }


    public void setNm(String nm) {
        this.nm = nm;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


}