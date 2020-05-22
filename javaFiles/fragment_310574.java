@Test
public void locatePlayerCalculateSum() {
    Response response = given()
            .spec(footballCompetitions_requestSpecification)
            .when().get(EndPoint.TEAMS + EndPoint.SQUAD);
    int sum = response.path("squad.count { it.role == 'PLAYER' }");
    System.out.println(sum);
}