public static void main(String[] args) {
    Funcionarios valido = new Funcionarios();
    Funcionarios invalido = new Funcionarios();
    Funcionarios aux = new Funcionarios();

    Pattern filtro_numero = Pattern.compile("-?[\\\\d\\\\.]+", Pattern.CASE_INSENSITIVE);

    aux.nome.add("Juan");
    aux.nome.add("Ju4n");
    aux.nome.add("Simon");
    aux.nome.add("S1mon");

    String aux_teste;
    int i = 0;
    while (i < aux.nome.size()) {
        Matcher somente_letras = filtro_numero.matcher(aux.nome.get(i));
        aux_teste = aux.nome.get(i);
        //if (!somente_letras.find()) {
        if(aux_teste.matches("[a-zA-Z]+$")){
            valido.nome.add(aux_teste);
        }
        else{
            invalido.nome.add(aux_teste);
        }
        i++;
    }

    System.out.println("Invalidos");
    System.out.println(invalido.nome);

    System.out.println("Validos");
    System.out.println(valido.nome);
}