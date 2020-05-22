class Login {

    Empresa empresa;

    class Empresa {

        // This is the solution 
        List<Contato> listaContato = new ArrayList<>();
        // Or the following
        // @SerializedName("listaContato")
        // List<Contato> contato = new ArrayList<>();
        // None of the solutions can fix the default empty array list though

        class Contato {

            int idContato;
            String contato;
            String tipoContato;

        }

    }

}