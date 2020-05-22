@Entity
@Table(name = "etudiant")

    public class Student {
        @Id
        @Column(name="Apogee")
        private int id;
        @Column(name="Prenom")
        private String first_name;
        @Column(name="Nom")
        private String last_name;
        @Column(name="Classement")
        private int rank;
        @Column(name="Filiere")
        private String speciality;
        @ManyToOne
        @JoinColumn(name = "Offre")
        private Offer school; 
        /* GETTERS SETTERS CONSTRUCTORS */
    }