public class UnidadeSaude {

    private String nomeUnidade;
    private static List<String> nomeUnidades = new ArrayList();

    public UnidadeSaude() {

    }

    public UnidadeSaude(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    void gravar(String NomeUnidade) {
        nomeUnidades.add(NomeUnidade);
    }

    void ler() {
        for (String nome : nomeUnidades) {
            System.out.println(nome);
        }
    }
}