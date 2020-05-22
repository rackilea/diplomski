static List<SomeObject> processSomeObject(SomeObject someObject) {
    List<ExtraData> extraDataList = getExtraData(someObject.getId());
    List<SomeObject> someObjectListTemp = new ArrayList<>();
    if (extraDataList.isEmpty()) {
        someObjectListTemp.add(someObject);
    } else {
        for (ExtraData extraData : extraDataList) {
            SomeObject someObjectTemp = (SomeObject) cloneObject(someObject);
            if (extraData != null) {
                someObjectTemp.setDate(extraData.getDate());
                someObjectTemp.setData2(extraData.getData2());
            }
            someObjectListTemp.add(someObjectTemp);
            System.out.println("Added object to list");
        }
    }

    return someObjectListTemp;
}