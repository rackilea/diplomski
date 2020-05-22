package com.rojmat.entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.core.annotation.Order;

@Entity
@Table(name="credit")
public class Credit extends BaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long cid;
    @Column @Order
    private long openingbalance;
    @Column
    private Date date;
    @Column @Order
    private long debittotal;
    @Column @Order
    private long drawertotal;
    @Column @Order
    private long debittotalplusdrawertotal;
    @Column @Order
    private long todaybusiness;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinTable(name="credit_debit", 
               joinColumns=@JoinColumn(name="c_id"), 
               inverseJoinColumns=@JoinColumn(name="d_id"))
    /*@JoinColumn(name="cid", referencedColumnName="cid")*/
    private List<Debit> debits = new ArrayList<Debit>(Arrays.asList());
    public Credit() {

    }
    public Credit(long cid, long openingbalance, Date date, long debittotal, long drawertotal,
            long debittotalplusdrawertotal, long todaybusiness, List<Debit> debits) {
        super();
        this.cid = cid;
        this.openingbalance = openingbalance;
        this.date = date;
        this.debittotal = debittotal;
        this.drawertotal = drawertotal;
        this.debittotalplusdrawertotal = debittotalplusdrawertotal;
        this.todaybusiness = todaybusiness;
        this.debits = debits;
    }
    public long getCid() {
        return cid;
    }
    public void setCid(long cid) {
        this.cid = cid;
    }
    public long getOpeningbalance() {
        return openingbalance;
    }
    public void setOpeningbalance(long openingbalance) {
        this.openingbalance = openingbalance;
    }   
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public long getDebittotal() {
        return debittotal;
    }
    public void setDebittotal(long debittotal) {
        this.debittotal = debittotal;
    }
    public long getDrawertotal() {
        return drawertotal;
    }
    public void setDrawertotal(long drawertotal) {
        this.drawertotal = drawertotal;
    }
    public long getDebittotalplusdrawertotal() {
        return debittotalplusdrawertotal;
    }
    public void setDebittotalplusdrawertotal(long debittotalplusdrawertotal) {
        this.debittotalplusdrawertotal = debittotalplusdrawertotal;
    }
    public long getTodaybusiness() {
        return todaybusiness;
    }
    public void setTodaybusiness(long todaybusiness) {
        this.todaybusiness = todaybusiness;
    }
    public List<Debit> getDebit() { 
        return debits;
    }   
    public void setDebit(List<Debit> debit) {   
        this.debits = debits;
    }
    /*@Override
    public String toString() {
            return "Credit [cid=" + cid + ", openingbalance =" + openingbalance + ", date=" + date + ", debittotal= " + debittotal + ", debittotalplusdrawertotal=" + debittotalplusdrawertotal + ", todaybusiness=" + todaybusiness + "]";
    }*/
}