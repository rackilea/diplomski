User user = new User();
Address address = new Address();

address.setUser(User);
user.addAddress(address);

em.persist(user);//you can delete this, if you add PERSIST (address.user field) to the @ManyToOne(cascade = { javax.persistence.CascadeType.REFRESH, javax.persistence.CascadeType.MERGE })
em.persist(address);