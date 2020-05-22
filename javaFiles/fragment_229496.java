private String fudge;
public Fudge(final String fudge) {
    this.fudge = fudge;
}

@Autowired
private GenericFudge fudge;

@PostConstruct
private void register() {
    fudge.addType(fudge, this);
}