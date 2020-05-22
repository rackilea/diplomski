@Query("SELECT r FROM Reservation r  " +
        "WHERE r.reservationSeance.id=:seanceId AND r.seanceDate=:seanceDate " +
        "ORDER BY r.id DESC")
public Reservation findReservationBySeanceDateAndSeanceId(
        @Param("seanceId") int seanceId,
        @Param("seanceDate") java.time.LocalDate seanceDate, Pageable pageable);