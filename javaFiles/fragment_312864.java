@Entity
public class SomeClass {

...

@Column
private String myValue;

 ...

 public Optional getMyValue() {
    return Optional.ofNullable(myValue);
 }

 public void setMyValue(LocalDate myValue) {
    this.myValue= myValue;
 }
...
}