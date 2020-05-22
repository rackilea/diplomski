public static boolean getData(String ids){
    String idAry[] = ids.split(",");
    List<String> idList = Arrays.asList(idAry);

    MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
        .add("loc", "message", idList).get();
    ...