KeyValueGroupedDataset<String, Etablissement> ets = dsEtablissements.groupByKey((MapFunction<Etablissement, String>) value -> value.siren, Encoders.STRING());

    Dataset<EtablissementList> etm = ets.mapGroups((MapGroupsFunction<String, Etablissement, EtablissementList>) (key, values) -> {
        Map<String, Etablissement> map = new HashMap<>();
        while (values.hasNext()) {
            Etablissement etablissement = values.next();
            map.put(etablissement.getId(), etablissement);
        }

        return new EtablissementList(map, key);
    }, Encoders.bean(EtablissementList.class));

    Dataset<Tuple2<Entreprise, EtablissementList>> dx = dsEntreprises.joinWith(etm, dsEntreprises.col("siren").equalTo(etm.col("siren")), "inner");
    Dataset<Entreprise> finalDs = dx.map((MapFunction<Tuple2<Entreprise, EtablissementList>, Entreprise>) value -> {
        value._1.etablissements = value._2.etablissements;
        return value._1;
    }, Encoders.bean(Entreprise.class));

    finalDs.foreach((ForeachFunction<Entreprise>) x -> System.out.println(x));