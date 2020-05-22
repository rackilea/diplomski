public class testaTemplateMethod {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(500);
        IKCV ikcv = new IKCV();
        ikcv.calcula(orcamento);
        System.out.println("Calcula: " + ikcv.calcula(orcamento));
        // or ikcv.minimaTaxacao(orcamento) or whatever
    }
}