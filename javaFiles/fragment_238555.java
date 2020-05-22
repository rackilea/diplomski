public class Subarea {
    private String nome;
    private Integer id;
    private Grafs grafs;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Grafs getGrafs() {
        return grafs;
    }
    public void setGrafs(Grafs grafs) {
        this.grafs = grafs;
    }
    @Override
    public String toString() {
        return "Subarea [nome=" + nome + ", id=" + id + ", grafs=" + grafs
                + "]";
    }
}