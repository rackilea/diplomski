@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BLOCK_OID")
    long blockOid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.block", cascade=CascadeType.ALL)
    Set<Account> accounts = new HashSet<Account>();
}

@Entity
public class Account {

    @EmbeddedId BlockAccountId id;

    public Account()
    {
        this.id = new BlockAccountId();
    }

    public void setBlock(Block pBlock) {        
        this.id.setBlock(pBlock);
    }

    public Block getBlock() {
        return this.id.getBlock();
    }

    public String getAccountRole() {    
        return this.id.getAccountRole();
    }

    public void setAccountRole(String accountRole) { 
        this.id.setAccountRole(accountRole);
    }
}


@Embeddable
public class BlockAccountId implements java.io.Serializable {

    @ManyToOne(optional = false)    
    private Block block;

    @Column(name = "ACCOUNT_ROLE", nullable = false, length = 10)
    private String accountRole;

    public BlockAccountId() {

    }

    //Implement equals and hashcode
}