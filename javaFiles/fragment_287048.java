public void resetResultFile() {
    JsonResult jsonResult = new JsonResult();
    ObjectMap<String, Integer> initialScores = new ObjectMap<>(1);
    initialScores.put("level_1", 0);
    jsonResult.setScores(initialScores);
    json.toJson(jsonResult, resultJson);
}