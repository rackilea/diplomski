Set<MyObj> set = new HashSet<>();
List<MyObj> result = new ArrayList<>();
for (Foo foo : foos) {
    MyObj myObj = new MyObj(foo);
    if(set.add(myObj))
        result.add(myObj);
}
result.sort(null);
return result;