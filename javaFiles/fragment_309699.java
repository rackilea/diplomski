@Entity
@IdClass(TestPK.class)
public class Test {

@Id
private String first;
@Id
private String second;

}

TestPk {

private String first;
private String second;

}

em.find(Test.class, testPKInstance);