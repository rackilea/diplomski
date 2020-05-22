@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
        name="REFD02"
        , joinColumns={
            @JoinColumn(name="R2$RES")
            }
        , inverseJoinColumns={
            @JoinColumn(name="R2$USR")
            }
        )
private List<Utilizador> refd00s;