public class Ticket implements Serializable{

private String name;
private LocalDateTime issued;

public Ticket() {
}

public Ticket(String name, LocalDateTime issued) {
    this.name = name;
    this.issued = issued;
}

/**
 * @return the name
 */
public String getName() {
    return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}

/**
 * @return the issued
 */
public LocalDateTime getIssued() {
    return issued;
}

/**
 * @param issued the issued to set
 */
public void setIssued(LocalDateTime issued) {
    this.issued = issued;
}