@Embeddable
public class EcranChampId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_champ")
    Champ champ; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ecran")
    Ecran ecran;
    //getters & setters 
}


EcranChamp ec = new EcranChamp();
EcranChampId  id = new EcranChampId();
id.setChamp(c);
id.setEcran(e);
ec.setId(id);