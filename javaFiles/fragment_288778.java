@Id @OneToOne
@JoinColumn(name="id_client1")
private Client newClient;
@ManyToOne
@JoinColumn(name="id_client2")
private Client oldFella;