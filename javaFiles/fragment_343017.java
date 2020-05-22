@Entity
class Dataset {
    @Id
    @Column(name="ID")
    public Long id;
    ...
    @OneToMany
    @JoinColumn(name="DATASET_ID", referencedColumnName="ID")
    public List<Document> documents = new ArrayList<Document>();
}