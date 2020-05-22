@ManyToMany(fetch = FetchType.EAGER, targetEntity=ClientsBasic.class)
@JoinTable(name = "clients_access_resources", 
joinColumns = {@JoinColumn(name ="res_id")}, 
inverseJoinColumns = {@JoinColumn(name = "client_id")})
public Set<ClientsBasic> getClientsBasics() {
return this.clientsBasics;
}