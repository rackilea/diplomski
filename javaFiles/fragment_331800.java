Dataset<ProcessEdr> cogg = edrs.cogroup(charges, (subscription_id, edrsIter, chargesIter) -> {
            ArrayList<ProcessEdr> results = new ArrayList<>();

            System.out.println("App Provider name" + appProvider.value().getIssuer_name());

            return results.iterator();
        }, Encoders.bean(ProcessEdr.class));