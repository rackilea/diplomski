@Query("SELECT description, modelYear, takeRate, number " +
      "FROM foo f " +
      "INNER JOIN bar b " +
      "ON b.cyclePlanCode = b.cyclePlanCode " +
      "WHERE b.programme = :programme " +
      "AND b.build_event = :buildEvent " +
      "AND f.vehicle_line = :vehicleLine " +
      "GROUP BY description, takeRate, modelYear, number")


List<SubFooEntity> findAllFooByBar(@Param("vehicleLine") String vehicleLine, @Param("programme") String programme,
                                          @Param("buildEvent") String buildEvent);