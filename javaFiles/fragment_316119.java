public interface ProfesionalCensoProjection {
    Long getIdProfesional();
    String getName();
    String getSurname();
    // returns a projection which would include only the description
    List<AusenciaSumaryprojection> getExclusionesCenso(); 
}

public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {

    List<ProfesionalCensoProjection> findCenso();
}