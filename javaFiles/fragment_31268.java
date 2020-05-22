@Id
@GenericGenerator(name = "sequenceGenerator", strategy = "enhanced-sequence",
    parameters = {
        @org.hibernate.annotations.Parameter(
            name = "optimizer", 
            value = "pooled"),
        @org.hibernate.annotations.Parameter(
            name = "initial_value", 
            value = "1"),
        @org.hibernate.annotations.Parameter(
            name = "increment_size", 
            value = "5")
    }
)
@GeneratedValue(
    strategy = GenerationType.SEQUENCE, 
    generator = "sequenceGenerator")
private Long id;