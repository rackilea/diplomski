@Scope("session")
@Component("PhaseComponent")
public class PhaseComponentImpl implements PhaseComponent ,Converter {
    //your fields...
    //your current methods...
    @PostConstruct
    public void init() {
        //initialize the data here
        this.phase = new Phase();
        //similar for other fields
    }
}