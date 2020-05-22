@Entity
        @Table(name = "users")
        public class Users implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        public String username;
        public String password;
        public Integer privid;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
        private Collection<Privillages> priviJoin;

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }

        @OneToOne()
        @JoinColumn(name="pname")
        private Privillages privillages;

        @Column(name = "username")
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        @Column(name = "password")
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        @Column(name = "privid")
        public Integer getPrivid() {
            return privid;
        }
        public void setPrivid(Integer privid) {
            this.privid = privid;
        }

        public Collection<Privillages> getPriviJoin() {
            return priviJoin;
        }
        public void setPriviJoin(Privillages priviJoin) {
            this.priviJoin = (Collection<Privillages>) priviJoin;
        }

        public Users() {
        }
        @Override
        public String toString() {
            return String.format("Users[id=%d, username='%s', password='%s']", id, 
        username, password);
        }
        /**
         * @return the pvs
         */
        public Privillages getPvs() {
            return pvs;
        }
        /**
         * @param pvs the pvs to set
         */
        public void setPvs(Privillages pvs) {
            this.pvs = pvs;
        }
    }