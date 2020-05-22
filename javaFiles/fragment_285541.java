@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner",  fetch=FetchType.EAGER)
    private Set<Pet> pets;

    public Set<Pet> getCats() {
        Set<Pet> cats = new HashSet<Pet>();
        for (Pet pet : getPetsInternal()) {
            if (pet.getType().getName().equals("cat")) {
                cats.add(pet);
            }
        }
        return cats;
    }
}