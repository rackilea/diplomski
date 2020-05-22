Query query = session.createQuery(" FROM FlightHasSteward where Flight_idFlight = :code");
query.setParameter("code", flightid);
List<FlightHasSteward> result = query.list();
final List<FlightHasSteward> res = (List<FlightHasSteward>) query.list();
for (final FlightHasSteward steward : res) {
        System.out.println(steward.getId().getStewardIdsteward());
}