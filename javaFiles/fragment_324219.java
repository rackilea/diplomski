class Criteria {
    @SerializedName("DisciplineId")  int disciplineId;
    @SerializedName("SeasonId")      int seasonId;
    @SerializedName("Leagues")       List<Integer> leagues; // Change Integer to datatype
    @SerializedName("StartDate")     String startDate;
    @SerializedName("EndDate")       String endDate;
    @SerializedName("RoundId")       int roundId;
    @SerializedName("GroupId")       int groupId;
    @SerializedName("MatchesScores") int matchesScores;
}