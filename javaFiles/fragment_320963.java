List<Pets> resultList = new LinkedList<>();
List<Pets> firstList  =  {"cats", "mice"};
List<Pets> secondList = {"dogs", "cats", "parrots", "mice", "hamsters", "guinea pigs"};

secondList.removeAll(firstList);//{"dogs", "parrots", "hamsters", "guinea pigs"}

resultList.addAll(firstList);//{"cats", "mice"}
resultList.addAll(secondList);//{"cats", "mice", "dogs", "parrots", "hamsters", "guinea pigs"}