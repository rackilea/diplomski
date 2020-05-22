public class Controlador implements Serializable {

    ...

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "controlador") 
    public CruceSemaforos getCruce() {
        return cruce;
    }

}