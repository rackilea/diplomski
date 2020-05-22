@SpringComponent
@UIScope
public class FuelEditor extends VerticalLayout{

TextField date = new TextField("Data");
TextField price = new TextField("Cena");
TextField amount = new TextField("Kwota tankowania");

Binder<Fuel> binder = new Binder<>(Fuel.class);

@Autowired
public FuelEditor(FuelReposiotry fuelReposiotry) {

    // Bind float fields manually
    binder.forField(price)
            .withConverter(new StringToFloatConverter("Value must be a float"))
            .bind(Fuel::getPrice, Fuel::setPrice);
    binder.forField(amount)
            .withConverter(new StringToFloatConverter("Value must be a float"))
            .bind(Fuel::getAmount, Fuel::setAmount);
    // bind the last using naming convention
    binder.bindInstanceFields(this);
}