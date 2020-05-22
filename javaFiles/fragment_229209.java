@Entity
@Table(name = "privillages")
public class Privillages implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer id;
@Column(name="pname")
public String pname;


@ManyToOne(optional = false)
@JoinColumn(name = "pid", referencedColumnName = "privid")
public Users pid;

public Integer getId() {
    return id;
}


@OneToOne(fetch=FetchType.LAZY, mappedBy="privillages")
private Users user;

public void setId(Integer id) {
    this.id = id;
}

@Column(name = "pname")
public String getPname() {
    return pname;
}
public void setPname(String pname) {
    this.pname = pname;
}

@Column(name = "pid")
public Users getPid() {
    return pid;
}
public void setPid(Users pid) {
    this.pid = pid;
}

public Privillages(){
} 
}