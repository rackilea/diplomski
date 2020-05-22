@Override
public List<Pojo> getLog(Pojo pojo) {

    Map<Long, Loja> mapLoja = new HashMap<>();
    Map<Long, Seguradora> mapSeguradora = new HashMap<>();
    Map<Long, TabelaSeguro> mapTabelaSeguro = new HashMap<>();

    List<Pojo> auditedList = super.getLog(pojo);

    if (!NullUtil.isNull(auditedList)) {

        for (Pojo pojoAudited : auditedList) {

            Long id = null;

            if (NullUtil.isNull(pojoAudited.getLojaMaster().getId())) {

                id = (Long) this.getIdentifier(pojoAudited.getLojaMaster());
                this.getLojaRegister(mapLoja, id);
                pojoAudited.setLojaMaster(mapLoja.get(id));
            }

            if (NullUtil.isNull(pojoAudited.getSeguradora().getId())) {

                id = (Long) this.getIdentifier(pojoAudited.getSeguradora());
                this.getSeguradoraRegister(mapSeguradora, id);
                pojoAudited.setSeguradora(mapSeguradora.get(id));
            }

            if (NullUtil.isNull(pojoAudited.getTabelaSeguro().getId())) {

                id = (Long) this.getIdentifier(pojoAudited.getTabelaSeguro());
                this.getTabelaSeguroRegister(mapTabelaSeguro, id);
                pojoAudited.setTabelaSeguro(mapTabelaSeguro.get(id));
            }

        }
    }

    return auditedList;
}

private void getLojaRegister(Map<Long, Loja> mapLoja, Long id) {

    if (!mapLoja.containsKey(id)) {
        Loja loja = this.findById(id);
        mapLoja.put(id, loja);
    }
}

private void getSeguradoraRegister(Map<Long, Seguradora> mapSeguradora, Long id) {

    if (!mapSeguradora.containsKey(id)) {
        Seguradora seguradora = this.getSeguradoraService().findById(id);
        mapSeguradora.put(id, seguradora);
    }
}

private void getTabelaSeguroRegister(Map<Long, TabelaSeguro> mapTabelaSeguro, Long id) {

    if (!mapTabelaSeguro.containsKey(id)) {
        TabelaSeguro tabelaSeguro = this.getTabelaSeguroService().findById(id);
        mapTabelaSeguro.put(id, tabelaSeguro);
    }
}