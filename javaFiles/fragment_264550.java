@Entity
public class ClassA {

    @Id
    @GeneratedValue 
    private Integer id;

    // Hibernate will create CLASSA_APPROVALITEM to link both class
    @OneToMany
    private List<ApprovalItem> approvalItemList;

}

@Entity
public class ClassB {

    @Id
    @GeneratedValue 
    private Integer id;

    // Hibernate will create CLASSB_APPROVALITEM to link both class
    @OneToMany
    private List<ApprovalItem> approvalItemList;

}