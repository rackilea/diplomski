@Entity
public class MainEntity{
    @Id
    private Integer ID;

    @Column(name="SOMEFIELD")
    private String SomeField;

    @Formula("(SELECT ot1.LABEL FROM OtherTable1 ot1 WHERE ot1.CODE = CODE_FK_1)")
    private String Label1;

}