@Entity
@Table(name = "TESTCASE_NEW")
@FilterDefs({
        @FilterDef(name = "TESTCASE_NAME_FILTER", defaultCondition = "TESTCASENAME like :TESTCASENAME", parameters = { @ParamDef(name = "TESTCASENAME", type = "string") }),
        @FilterDef(name = "TEST_RUN_ID_FILTER", defaultCondition = "TESTRUNID in (:IDS)", parameters = { @ParamDef(name = "IDS", type = "int") })
})
public class TestCase implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TESTCASEID")
    private int ID;

    @Column(name = "TESTCASENAME")
    private String name;

...
}

@Entity
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CATEGORYID")
    private int ID;

    @Column(name = "CATEGORYNAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORYID")
    @OrderBy("TESTCASEID desc")
    @Filters({
            @Filter(name = "TEST_RUN_ID_FILTER"),
            @Filter(name = "TESTCASE_NAME_FILTER") })
    private Collection<TestCase> testCases;

...
}