public String getName() {
    String expressao = entityClass.getName();
    String nome_classe = new String();
    StringTokenizer st = new StringTokenizer(expressao, ".");
    while (st.hasMoreTokens()) {
        nome_classe = st.nextToken();
    }
    return nome_classe;
}