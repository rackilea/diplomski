public interface ServiceContract {
    void save(Model model);
}

public class ServiceContractImpl implements ServiceContract, Validatable {
    @Override
    public void save(@Valid Model model) {}
}