//SQL query

select distinct credit.idCredit as idCredit from Credit credit Left Join Debit debit on credit.idCredit= debit.idCredit

//HQL query 

@Entity(name = "Credit")
@Table(name = "Credit")
public class Credit{


    //if you put @Id  --> HQL Query "select credit from Credit credit"
    @Column(name = "idCredit")
    private Long idCredit;

    @Column(name = "label")
    private String label;

    @OneToMany 
    @JoinColumns({@JoinColumn(name = "idCredit" ,referencedColumnName = "idCredit")})
    List<Debit> debits;

  ...
}
public class Debit{
    ....


    @Column(name = "idCredit")
    private Long idCredit;
    ...
}

    Query query = getSession().createQuery("select distinct credit.idCredit as idCredit, credit.label as label, credit.debits as debits from Credit credit   ");
    query.setResultTransformer(Transformers.aliasToBean(Credit.class));
    return query.list();