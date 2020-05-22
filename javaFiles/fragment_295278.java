@ManagedBean(name="testBean")
@SessionScoped
public class TestBackingBean 
{
    /**
     * The input filter
     */
    private String filter = StringUtils.EMPTY;

    /**
     * Some test data
     */
    private final List<Car> carModels = new ArrayList<Car>() {
        {
            add(new Car("toyota"));
            add(new Car("honda"));
            add(new Car("suzuki"));
            add(new Car("ford"));
            add(new Car("renault"));
            add(new Car("subaru"));
        }
    };

    /**
     * For updating the grid.
     */
    public void onValueChange(AjaxBehaviorEvent event)
    {
        AutoComplete ac = (AutoComplete) event.getSource();

        Car input = (Car) ac.getValue();

        filter = (input == null) ? StringUtils.EMPTY : input.getCarmodel();
    }

    /**
     * For the auto complete drop down
     */
    public List<Car> complete(String input)
    {
        filter = input;

        return getMatchingCarModels();
    }

    /**
     * get the match
     */
    public List<Car> getMatchingCarModels()
    {
        if(StringUtils.isEmpty(filter))
            return carModels;

        List<Car> matches = new ArrayList<Car>();

        for(Car car : carModels)
        {
            if(car.getCarmodel().startsWith(filter))
            {
                matches.add(car);
            }
        }

        return matches;
    }

    /**
     * The selected car
     */
    private Car selectedCar;
    //Add setters and getters for above member
}