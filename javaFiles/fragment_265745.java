@ManagedBean
    @ViewScoped
    public class TestController implements Serializable
    {
        private static final long serialVersionUID = 1L;

        private String teste;

        public String getTeste()
        {
            return teste;
        }

        public void setTeste(String teste)
        {
            this.teste = teste;
        }
    }