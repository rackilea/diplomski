@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Channel {
    @Id
    @GeneratedValue
    private Long id;

    // ...
}

@Entity
public class Fax extends Channel {
}

@Entity
public class Email extends Channel {
}

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Channel channel;

    // ...
}