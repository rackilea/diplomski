ObjectMapper mapper = new ObjectMapper();
PL pl = mapper.readValue(json, PL.class);
for(ResponseData rd : pl.getResponseDatas()) {
    System.out.println(rd.getX());
    System.out.println(rd.getY());
}