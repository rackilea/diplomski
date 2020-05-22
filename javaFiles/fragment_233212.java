@Entity
class Parameter{

    @Column(name="order")
    private int order;

    @column(name="parameter")
    private String parameter;

    @column(name="value")
    private String value;

} 

@Entity
class User{

    @column(name="id")
    private int id;

    @OneToMany(cascade=ALL)
    @JoinTable(name="SECONDARY", 
        joinColumns={@JoinColumn(name="id")},
        inverseJoinColumns=@JoinColumn(name="order"))
    @MapKeyJoinColumn(name="parameter")
    private Map<String,Parameter> userData;

    public String getUserName(){
        return userdata.get("user_login")
    }

    etc.

}