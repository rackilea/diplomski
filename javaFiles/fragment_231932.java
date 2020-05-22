try ( final JsonReader jsonReader = Resources.getPackageResourceJsonReader(Q50361018.class, "whatever.json") ) {
    final Login login = gson.fromJson(jsonReader, Login.class);
    login.empresa.listaContato
            .stream()
            .limit(2)
            .forEach(contato -> System.out.println(contato.idContato + " " + contato.contato + " " + contato.tipoContato));
}