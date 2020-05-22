@Entity
@BeanModels({ @BeanModel(reorder = "id") })
public class Client{

    private List<Contract> contracts = new ArrayList<Contract>();

    @OneToMany(cascade = { CascadeType.ALL })
    public List<Contract> getContracts() {
        return contracts;
    }

[...]

}