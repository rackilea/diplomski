public void saveResult(Integer level, Integer newScore) {
    JsonResult jsonResult = json.fromJson(JsonResult.class, resultJson);
    ObjectMap<String, Integer> scores = jsonResult.getScores();
    String levelKey = "level_" + level;
    Integer scoreForLevel = scores.get(levelKey);
    if (newScore > scoreForLevel) {
         scores.put(levelKey, newScore);
         jsonResult.setScores(scores);
         json.toJson(jsonResult, resultJson);
    }
}