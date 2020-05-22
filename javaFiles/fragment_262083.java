public class ClassB {

int account = 3000;
String firstname = "Coder";
String lastname = "ACJHP";
int balance = 300;

public String getDatas() {
    return new String(account + firstname + lastname + balance);
  }
}