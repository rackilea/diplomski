// This is pseudo code
    @OneToMany(mappedBy = "--" cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<?> -- = ;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "--", nullable = false)
    @JsonBackReference
    private -- --;