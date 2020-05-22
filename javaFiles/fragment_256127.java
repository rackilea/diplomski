@Entity
@Table(name="d_intervenant_tc")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type", discriminatorType=DiscriminatorType.STRING)
public class Intervenant {

}

@Entity
public class Affilie extends Intervenant{
}