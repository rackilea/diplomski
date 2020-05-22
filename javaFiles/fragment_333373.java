@Entity
@Table(name = 'message')
@Access(AccessType.PROPERTY)
public class Message extends BusinessEntity {

private static final long serialVersionUID = 1L;

}

@Entity
@Table(name = 'event')
@Access(AccessType.PROPERTY)
public class Event extends BusinessEntity {

private static final long serialVersionUID = 1L;

}