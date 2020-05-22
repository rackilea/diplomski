for (Integer k: emap.keySet()) {
    Employee e = emap.get(k);
    if (e.getSalary() < 45000.0) {
        lowSalaryEmployees.put(k, e);
    } else {
        highSalaryEmployees.put(k, e);
    }
}

hmap.put(0, lowSalaryEmployees);
hmap.put(1, highSalaryEmployees);