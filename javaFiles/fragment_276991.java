@ManyToOne
@JoinColumns({
    @JoinColumn(name="TNO", referencedColumnName="TNO"),
    @JoinColumn(name="DNO", referencedColumnName="DNO")
})
private Fixture fixture;