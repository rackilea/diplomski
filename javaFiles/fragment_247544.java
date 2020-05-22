class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // other fields
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    @Column(name = "vacations")
    @JsonIgnoreProperties("user")
    private Set<Vacation> vacations = new HashSet<>();
}

class Vacation{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "begin_date")
    private LocalDateTime beginDateOfVacation;

    @NotNull
    @Column(name = "end_date")
    private LocalDateTime endDateOfVacation;

    @NotEmpty
    @Column(name = "type")
    private String typeOfVacation;

    @NotEmpty
    @Column(name = "reason")
    private String reasonOfVacation;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("vacations")
    private User user;
}