@Id
@GeneratedValue(
    strategy= GenerationType.AUTO, 
    generator="native"
)
@GenericGenerator(
    name = "native", 
    strategy = "native"
)
private Long id;