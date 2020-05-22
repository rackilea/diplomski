@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "autorizacoes_usuario", joinColumns = { @JoinColumn(name = "fk_usuario") }, inverseJoinColumns = { @JoinColumn(name = "fk_autorizacoes") })
    //@LazyCollection(LazyCollectionOption.TRUE)
    public List<Autorizacoes> getAutorizacoes() {
        return this.autorizacoes;
    }