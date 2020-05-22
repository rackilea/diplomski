class Person {

   private String id;

   @OneToMany(mappedBy="owner")
   private List<Contact> contacts;

}

class Contact {

   private String id;

   @ManyToOne(fetch = FetchType.Lazy)
   @JoinColumn(name="owner_id", nullable=false,updatable=false)
   private Person owner;

   @Column("owner_id")
   private String ownerId;

}