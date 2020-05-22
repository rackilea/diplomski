@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner",  fetch=FetchType.EAGER)
    private Set<Pet> pets;

    public Set<Pet> getCats() {
        return Sets.filter(getPetsInternal(), new Predicate<Pet>() {
            public boolean apply(Pet pet) { 
                return pet.getType().getName().equals("cat")
            }
        });         
    }
}