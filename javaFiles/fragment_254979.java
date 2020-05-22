@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface RoomTipologyDAO extends JpaRepository<RoomTipology, Long> {

   List<RoomTipology> findByRooms_Accomodation(Accomodation accomodation);

}