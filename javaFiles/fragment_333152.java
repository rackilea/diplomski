@Entity
public abstract class Pet<OWNER extends PetOwner<?>> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(optional = false, targetEntity = PetOwner.class)
    private OWNER owner;
}

@Entity
public abstract class PetOwner<PET extends Pet<?>> implements Serializable {

    @Id
    private String id;

    private String firstName;

    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL, targetEntity = Pet.class)
    private List<PET> pets;
}