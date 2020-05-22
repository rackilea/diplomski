Map<String, List<String>> result2 = new TreeMap<>();

for(String eachDept : department.keySet()){
    List<String> peopleInTheDept = department.get(eachDept);
    if(peopleInTheDept.contains(aValue)){
            result2.put(eachDept, department.get(eachDept));
    }
}
for (String s : result2.keySet()){
    System.out.println(s + " " + result2.get(s));
}