package br.com.ar.model.domain;

@Entity
/**
  * I am using InheritanceType.SINGLE_TABLE instead of TABLE_PER_CLASS
  * Because MySQL (DB used) DOES NOT SUPPORT identity generation strategy
  * Otherwise, i will get some Exception
  */
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="BILLING_DETAILS_TYPE",
    discriminatorType=DiscriminatorType.STRING
)
/**
  * ARE YOU SURE your Book class HAS BEEN MARKED AS abstract
  */ 
public abstract class AbstractChild implements Serializable {

    private Integer id;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}