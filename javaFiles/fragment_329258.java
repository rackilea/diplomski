Single<List<ResultType>> result = Single.zip(
    getData1().subscribeOn(Schedulers.io()),
    manipulateList2(sourceList2).subscribeOn(Schedulers.computation()),
    (list1, list2) -> getData3(list1, list2)
)
.flatMap(v -> v)
.flatMap(list3 -> manipulateList4(list3))
.flatMap(list4 -> 
    insertLog(list4).subscribeOn(Schedulers.io())
    .andThen(createResult(list4).subscribeOn(Schedulers.computation()))
);

return result;