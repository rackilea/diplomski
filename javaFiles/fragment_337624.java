public class Bean {
    private String nameFilterPattern;
    private List<Kunde> kunden;

    // Load during bean construction.
    public Bean() {
        this.kunden = getApplication().getKunden(getNameFilterPattern());
    }

    // OR load during @PostConstruct (will be invoked AFTER construction and resource injection.
    @PostConstruct
    public void init() {
        this.kunden = getApplication().getKunden(getNameFilterPattern());
    }

    // OR during bean initialization (this is invoked BEFORE construction and will apply to ALL constructors).
    {
        this.kunden = getApplication().getKunden(getNameFilterPattern());
    }

    // OR during bean action method (invoked from h:commandLink/Button).
    public String submit() {
        this.kunden = getApplication().getKunden(getNameFilterPattern());
        return "navigationCaseOutcome";
    }

    // OR using lazy loading pattern in getter method.
    public List<Kunde> getKunden() {
        if (this.kunden == null) 
            this.kunden = getApplication().getKunden(getNameFilterPattern());
        }
        return this.kunden;
    }