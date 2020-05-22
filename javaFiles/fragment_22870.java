@Id
@GenericGenerator(name="MyCustomGenerator", strategy="org.mytest.entity.CustomIdGenerator" )
@GeneratedValue(generator="MyCustomGenerator" )
@Column(name = "PM_ID", nullable = false, length=12)
private long pmId;

private Integer field1;

private Integer field2;

.... your getters and setters ....