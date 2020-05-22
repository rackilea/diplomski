@Entity
    @Table(name = "Consumer")
    @NamedQueries({...})
    public class Consumer implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;

        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(name = "userName")
        private String userName;     

        @OneToOne(cascade = CascadeType.ALL, mappedBy = "consumer")
        private ProfilePicture profilePicture;

        public void setProfilePicture(ProfilePicture profilePicture){
            //SET BOTH SIDES OF THE RELATIONSHIP
            this.profilePicture = profilePicture;
            profilePicture.setConsumer(this);
        }
}