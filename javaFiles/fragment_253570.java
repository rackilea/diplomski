Set<String> adminAreaID = getAdminStudents().stream()
        .map(Student::getId)
        .collect(Collectors.toSet());

return getAllStudents().stream()
        .filter(student -> adminAreaID.contains(student.getId()))
        .collect(Collectors.toSet());