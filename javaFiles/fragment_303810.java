class Entity {

    @Size(1)
    @OneToMany
    private List<InnnerEntity> innerEntity;

}