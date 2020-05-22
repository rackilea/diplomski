List<Student> listStudent = new ArrayList<>();
List<Map<String, String>> result = listStudent.stream()
        .map(student -> {
            return new HashMap<String, String>() {
                {
                    put("age", student.getAge());
                    put("name", student.getName());
                }
            };
        }).collect(Collectors.toList());