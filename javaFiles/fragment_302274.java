@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinTable(name="person_phones", 
    joinColumns = @JoinColumn(name = "f_person_pid", foreignKey = @ForeignKey(
            name = "fk_person_phones_person")), 
    inverseJoinColumns = @JoinColumn(name = "fk_phone",
            foreignKey = @ForeignKey(name = "fk_person_phones_phone")),
            uniqueConstraints = @UniqueConstraint(name = "uk_person_phones_phone",
            columnNames = { "fk_phone" }))
private List<Phone> phones = new ArrayList<>();