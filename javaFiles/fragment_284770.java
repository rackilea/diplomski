listOfPersons = [{2,Bob},{3,Claire},{1,Alice}]
orderList = [1,3,2]
sortedList = []
for(id in orderList)
    person = listOfPersons.lookup(id)
    sortedList.add(person)