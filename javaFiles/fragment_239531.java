@Entity
public class HospitalToDoctor implements Serializable {
    @Id
    @ManyToOne
    private Hospital hospital;

    @Id
    @ManyToOne
    private Doctor doctor;
}

@Entity
public class Hospital {
    @OneToMany(mappedBy = "hospital")
    private Collection<HospitalToDoctor> doctors;
}

@Entity
public class Doctor {
    @OneToMany(mappedBy = "doctor")
    private Collection<HospitalToDoctor> hospitals;
}