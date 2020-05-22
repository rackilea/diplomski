static class ReponseJSON {
    private Response Response;

    @JsonProperty("Response")
    public Response getResponse() {
        return Response;
    }

    public void setResponse(Response Response) {
        this.Response = Response;
    }

    static class Response {
        private String rid;
        private Itm Itm;
        private List<Itm> listItm = new ArrayList<Itm>();

        public Itm getItm() {
            return Itm;
        }

        @JsonProperty("Itm")
        public void setItm(Itm Itm) {
            this.Itm = Itm;
            listItm.add(Itm);
        }

        public String getRID() {
            return rid;
        }

        public List<Itm> getItms() {
            return listItm;
        }

        @JsonProperty("RID")
        public void setRID(String rid) {
            this.rid = rid;
        }

        static class Itm {
            private Id id;

            private String qw, name;

            public String getQw() {
                return qw;
            }

            public void setQw(String qw) {
                this.qw = qw;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Id getId() {
                return id;
            }

            public void setId(Id id) {
                this.id = id;
            }

            static class Id {
                private String ab, cd;

                public String getCd() {
                    return cd;
                }

                public void setCd(String cd) {
                    this.cd = cd;
                }

                public String getAb() {
                    return ab;
                }

                public void setAb(String ab) {
                    this.ab = ab;
                }
            }
        }
    }
}