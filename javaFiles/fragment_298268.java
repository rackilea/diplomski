WriteResult result = collection.insert(list, WriteConcern.FSYNC_SAFE);
CommanResult commandResult = result.getLastError();
if (commandResult.get("err") != null) {
    System.out.println("Alleluyah");
return true;
}