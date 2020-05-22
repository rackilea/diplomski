import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@Entity
@XmlRootElement(name="FIXML")
@XmlType(name="ExecRpt")
public class ExecutionReport implements Serializable {
    private String account;
    private String senderCompID;

    @Column(name="ACCOUNT", nullable=true, length=64)
    @XmlPath("ExecRpt/@Acct")
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name="SENDER_COMP_ID", nullable=true, length=200)
    @XmlPath("ExecRpt/Hdr/@SID")
    public String getSenderCompID() {
        return this.senderCompID;
    }
    public void setSenderCompID(String senderCompID) {
        this.senderCompID = senderCompID;
    }
}