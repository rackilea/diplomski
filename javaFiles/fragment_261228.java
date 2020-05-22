@Entity
@Table (name="icdtable", catalog="emscribedx")
public class Icdtable {
private Long _icdid;
private Long _cid;
private String _icdcode; //TODO: add this to hibernate mappings ('PN' or 'NN')
private String _status;
private String _create_date;
private String _kstatus;
private int _enterorder;
private String _poa;
private String _ppoa;
private String _userid;
private Code_table _code_table1;
private List<Proceduredetail> _proceduredetails;

@Id
@Column (name = "icdid")
public Long getIcdid() {
    return _icdid;
}
public void setIcdid(Long icdid_) {
    _icdid = icdid_;
}

@Column (name = "cid")
public Long getCid() {
    return _cid;
}
public void setCid(Long cid_) {
    _cid = cid_;
}

@Column (name = "icdcode")
public String getIcdcode() {
    return _icdcode;
}
public void setIcdcode(String icdcode_) {
    _icdcode = icdcode_;
}

@Column (name = "status")
public String getStatus() {
    return _status;
}
public void setStatus(String status_) {
    _status = status_;
}

@Column (name = "create_date")
public String getCreate_date() {
    return _create_date;
}
public void setCreate_date(String createDate_) {
    _create_date = createDate_;
}

@Column (name = "kstatus")
public String getKstatus() {
    return _kstatus;
}
public void setKstatus(String kstatus_) {
    _kstatus = kstatus_;
}

@Column (name = "enterorder")
public int getEnterorder() {
    return _enterorder;
}
public void setEnterorder(int enterorder_) {
    _enterorder = enterorder_;
}

@Column (name = "poa")
public String getPoa() {
    return _poa;
}
public void setPoa(String poa_) {
    _poa = poa_;
}

@Column (name = "ppoa")
public String getPpoa() {
    return _ppoa;
}
public void setPpoa(String ppoa_) {
    _ppoa = ppoa_;
}

@Column (name = "userid")
public String getUserid() {
    return _userid;
}
public void setUserid(String userid_) {
    _userid = userid_;
}

@ManyToOne
@JoinColumn(name = "cid", insertable=false, updatable=false)
public Code_table getCode_table() {
    return _code_table1;
}
public void setCode_table(Code_table code_table_) {
    _code_table1 = code_table_;
}

@OneToMany (mappedBy = "icdtable", targetEntity = Proceduredetail.class, cascade =  CascadeType.ALL)
public List<Proceduredetail> getProceduredetails() {
    return _proceduredetails;
}
public void setProceduredetails(List<Proceduredetail> proceduredetails_) {
    _proceduredetails = proceduredetails_;
}