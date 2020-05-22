String keya = listaParcelasGerarOrcamento.get(i).getDataPagamento();

List<ItensDespesaOrcamentoParcelas> lista = mapa.get(keya);
if (lista == null) {
  lista = new ArrayList<ItensDespesaOrcamentoParcelas>();
  mapa.put(keya, lista);
}
lista.addAll(listaItens);