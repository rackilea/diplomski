Map<String, Object> map1 = (Map<String, Object>) object1;
Map<String, Object> map2 = (Map<String, Object>) object2;
if ( flag == false ) {
    return new CompareToBuilder()
        .append(map1.get("employeeId"), map2.get("employeeId"))
        .append(map1.get("departmentId"), map2.get("departmentId"))
        .toComparison();
}
else {
    return new CompareToBuilder()
        .append(map2.get("employeeId"), map1.get("employeeId"))
        .append(map2.get("departmentId"), map1.get("departmentId"))
        .toComparison();
}