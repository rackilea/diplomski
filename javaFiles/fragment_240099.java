@Valid
@ElementCollection
@CollectionTable(schema="u",name="emails",joinColumns=@JoinColumn(name="person_fk"))
@AttributeOverrides({
    @AttributeOverride(name="email",column=@Column(name="email",nullable=false)),
})
public List<EmailU> getEmails() {
    return emails;
}