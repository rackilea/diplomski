import java.util.ArrayList;

public class Test {
private int personId;
private String name;
//getters and Setters



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + personId;
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
       return true;
    if (obj == null)
       return false;
    if (getClass() != obj.getClass())
       return false;
    Test other = (Test) obj;
    if (personId != other.personId)
       return false;
    return true;
}
public static void main(String[] args) {
    ArrayList<Test> test=new ArrayList<Test>();

Test t=new Test();
t.setName("Sireesh");
t.setPersonId(1);

Test t1=new Test();
t1.setName("Ramesh");
t1.setPersonId(2);

Test t2=new Test();
t2.setName("Rajesh");
t2.setPersonId(3);


test.add(t);
test.add(t1);
test.add(t2);

Test tx=new Test();
tx.setPersonId(1);
System.out.println(test.contains(tx));
//Returns true

}
}