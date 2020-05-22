@Entity
public class Person {

  @Column("nickName")
  public String getNickName(){
     if(this.name != null) return generateFunnyNick(this.name);
     else return "John Doe";
  }
}