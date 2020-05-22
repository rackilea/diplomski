//  v--- the code need to edit is here
List<Map<String, Long>> collect = docs
.map(doc -> doc.collect(Collectors.groupingBy(Function.identity()
 //                    the code need to edit is here ---v
                                             ,Collectors.counting())))
.collect(Collectors.toList());