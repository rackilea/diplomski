public class Row_ {
    private Integer id;
    private String nome;
    private String serv;
    private String periodo;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getServ() {
        return serv;
    }
    public void setServ(String serv) {
        this.serv = serv;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    @Override
    public String toString() {
        return "Row_ [id=" + id + ", nome=" + nome + ", serv=" + serv
                + ", periodo=" + periodo + "]";
    }
}