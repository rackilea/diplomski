@Entity
        @Table(name="tbl_genere")
        public class Data implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @Column(name="dataid")
        private String DataId;

        @Column(name="dataname")
        private String DataName;

        public String getDataId() {
            return DataId;
        }

        public void setDataId(String dataId) {
            DataId = dataId;
        }

        public String getDataName() {
            return DataName;
        }

        public void setDataName(String dataName) {
            DataName = dataName;
        }

        public String toString(){
        return DataId+","+DataName;
        }
}