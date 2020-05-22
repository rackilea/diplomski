public static class EtablissementList {
        private Map<String, Etablissement> etablissements = new ConcurrentHashMap<>();
        private String siren;

        public EtablissementList() {
        }

        public EtablissementList(Map<String, Etablissement> etablissements, String siren) {
            this.etablissements = etablissements;
            this.siren = siren;
        }

        public Map<String, Etablissement> getEtablissements() {
            return etablissements;
        }

        public void setEtablissements(Map<String, Etablissement> etablissements) {
            this.etablissements = etablissements;
        }

        public String getSiren() {
            return siren;
        }

        public void setSiren(String siren) {
            this.siren = siren;
        }
    }