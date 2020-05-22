Gson gson = new Gson();
try (Reader reader = new FileReader("foobar.json")) {
    Type type = new TypeToken<TreeMap<String, TreeMap>>() {
    }.getType();

    TreeMap<String, TreeMap<String, List<List<Object>>>> map = gson.fromJson(reader, type);

    List<Results> listaMutacoes = new ArrayList<>();

    for (Map.Entry<String, TreeMap<String, List<List<Object>>>> regioesMap : map.entrySet()) {

        TreeMap<String, List<List<Object>>> regiaoUm = regioesMap.getValue();

        for (Map.Entry<String, List<List<Object>>> regiaoUmResult : regiaoUm.entrySet()) {

            List<List<Object>> resultados = regiaoUmResult.getValue();

            for (List<Object> list : resultados) {

                System.out.println(list);

                Results resultado = new Results();
                resultado.setRegiaoAfetada(regioesMap.getKey());
                resultado.setPosicaoReferencia(regiaoUmResult.getKey());
                resultado.setNomeDoArquivo((String) list.get(0));
                resultado.setBaseAlteradaReferencia((String) list.get(1));
                resultado.setMutacaoEncontrada((List<String>) list.get(2));
                listaMutacoes.add(resultado);
            }
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}