class Login {

    Empresa empresa;

    class Empresa {

        List<Contato> contato = new ArrayList<>();

        class Contato {

            int idContato;
            String contato;
            String tipoContato;

        }

    }

}