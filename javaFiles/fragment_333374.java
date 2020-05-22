@Entity
@Table(name = 'event')
@Access(AccessType.PROPERTY)
public class Event extends BusinessEntity {

private static final long serialVersionUID = 1L;

private Message message;

@ManyToOne
public Message getMessage(){ return message;}
//setter
}

@Entity
@Table(name = 'event')
@Access(AccessType.Field)
public class Event extends BusinessEntity {

private static final long serialVersionUID = 1L;

@ManyToOne
private Message message;

public Message getMessage(){ return message;}
//setter
}