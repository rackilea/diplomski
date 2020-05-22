import java.io.Serializable;


public class Filial implements Serializable{

    private Long id;

    private String nmFilial;

    public Filial(){}

    public Filial(Long id, String nmFilial){
        this.id = id;
        this.nmFilial = nmFilial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmFilial() {
        return nmFilial;
    }

    public void setNmFilial(String nmFilial) {
        this.nmFilial = nmFilial;
    }
}