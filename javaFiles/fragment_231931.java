class Login {

    Empresa empresa;

}


class Empresa {

    // This will always be an empty array list even if there is `listaContato` in the JSON document
    List<Contato> listaContato = new ArrayList<>();

}

class Contato {

    int idContato;
    String contato;
    String tipoContato;

}