Dataset<Tuple2<Entreprise, Etablissement>> ds = dsEntreprises
                .joinWith(dsEtablissements,
                        dsEntreprises.col("siren").equalTo(dsEtablissements.col("siren")), "inner");

        KeyValueGroupedDataset<String, Tuple2<Entreprise, Etablissement>> dsK = ds.groupByKey((MapFunction<Tuple2<Entreprise, Etablissement>, String>)
                value -> value._1.siren, Encoders.STRING());

        dsK.mapGroups((MapGroupsFunction<String, Tuple2<Entreprise, Etablissement>, Entreprise>) (key, values) -> {
            Entreprise e = null;
            while (values.hasNext()) {
                Tuple2<Entreprise, Etablissement> tuple = values.next();
                if (e == null) {
                    e = tuple._1;
                }

                e.ajouterEtablissement(tuple._2);
            }

            return e;
        }, Encoders.bean(Entreprise.class))
                .foreach((ForeachFunction<Entreprise>) x -> System.out.println(x));