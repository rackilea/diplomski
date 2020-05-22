public ChecaOrtografia(Dicionario dicionario, Gramatica gramatica, Frase frase)
{
    listaFrases = new ArrayList<>();
    this.listaFrases.addAll(frase.listaFrases);
    listaDicionario =  new ArrayList<>();
    this.listaDicionario.addAll(dicionario.listaItens);
    listaGramatica =  new ArrayList<>();
    this.listaGramatica.addAll(gramatica.listaRegras);
}