public class Channel {

        private String name;
        private String oid;
        private ArrayList<Programme> alProgrammes;

        public Channel(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public ArrayList<Programme> getAlProgrammes() {
            return alProgrammes;
        }

        public void setAlProgrammes(ArrayList<Programme> alProgrammes) {
            this.alProgrammes = alProgrammes;
        }


    }