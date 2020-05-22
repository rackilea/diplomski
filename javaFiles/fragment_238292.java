/*
         * List of your nbr_fact objects
         */
        List<String> nbr_fact_objects= new ArrayList<>();
         /*
         * List of your mois_fact objects
         */
        List<String> mois_fact_objects= new ArrayList<>();

        JSONArray factures= json.getJSONArray("factures");
        for (int i = 0; i < factures.length(); i++) {
            JSONObject c = factures.getJSONObject(i);

            String nbr = c.getString("nbr_fact");
            if (nbr != null) {
                nbr_fact_objects.add(nbr);
            }
            String mois = c.getString("mois_fact");
            if (mois != null) {
                mois_fact_objects.add(mois);
            }

        }