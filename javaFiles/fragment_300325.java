Set<Integer> removeIds = new HashSet();
for(String resultItem: paging.getMoveRightArray().split(","))
     removeIds.add(Integer.parseInt(resultItem.split("-")[0]));
List<TestOV> tempList=new ArrayList(), newTempList=new ArrayList();
for(TestVO tempVO: availableList)
   (removeIds.contains(tempVO.getId()) ? tempList : newTempList).add(tempVO);