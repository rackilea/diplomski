//NOT Autowired
private PvsTTableModel model;

@Autowired
public KPI_PvsT(PvsTTableModel model) {
    this.model = model;
    [...]
}