@Autowired
public ChoseNumberOfTicketsView(SeansRepository repository) {
    Design.read(this);  
    this.repository = repository;
    movieComboBox = new ComboBox<>("Chose the movie");
    movieComboBox.setItems(repository.findAll());

}