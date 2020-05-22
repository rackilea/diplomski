public class A {    
    ...
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "a")
    @Fetch(FetchMode.SELECT)
    public List<B> getBs() {
        return this.bs;
    }       
    ...
}

public class B {        
    ...
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPKA")
    public A getA() {
        return this.a;
    }
    ... 
}