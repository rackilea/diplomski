public static Integer getSum(String jsonStr) {

    JSONObject jsonObject = JSONObject.parseObject(jsonStr);
    Set<String> keySet = jsonObject.keySet();
    Integer sum = keySet.stream().collect(Collectors.summingInt(k -> (int) jsonObject.get(k)));
    return sum;
}