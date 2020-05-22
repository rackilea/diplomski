List<int> filtered(List<Abc> list1, List<Abc> list2) {
    var dataStrings = setOf(list2.map(x -> x.dataString));

    var abcs = list1.filter(x -> dataStrings.contains(x.dataString));

    return abcs.map(x -> x.rowNum);
}