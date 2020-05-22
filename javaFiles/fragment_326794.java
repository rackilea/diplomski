@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractAnimal {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    ...
}

@Entity
public class Lion extends AbstractAnimal implements Animal {
    ...
}

@Entity
public class Tiger extends AbstractAnimal implements Animal {
    ...
}

@Entity
public class Zoo {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = AbstractAnimal.class)
    private Set<Animal> animals = new HashSet<Animal>();

    ...
}