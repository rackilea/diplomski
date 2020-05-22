public class Client {

private  String name;
private List<String> telephoneNumber;

Client(String name)
{
    this.name = name;
}

public List<String> getTelephoneNumber() {
    return telephoneNumber;
}

public void setTelephoneNumber(List<String> telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public boolean equals(Object obj)
{
    Client c = (Client)obj;
    return this.name.equals(c.name);
}