@ManyToMany
@JoinTable(name = "AB", 
            joinColumns = @JoinColumn( name = "idB"),
            inverseJoinColumns = @JoinColumn( name = "idA") )
public List<A> getAs(){
    //return the list of matching stuff
}