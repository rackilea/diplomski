@Entity
public class EntityA {
    @GeneratedValue
    @Id
    private Integer id;
    private Set<EntityB> entityBs;

    /* Getter & Setter */
}

public class EntityADto {
    private Integer id;
    private Set<EntityBDto> entityBDtos;

    /* Getter & Setter */
}