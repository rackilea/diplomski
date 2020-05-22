LinkedHashMap<Long, StudentDTO> studentMap = new LinkedHashMap<>();

for(AllStudents all : allStudents) {
    StudentDTO studentDTO = studentMap.get(all.getStudent().getId());
    if(studentDTO == null) {
        studentDTO = new StudentDTO(all.getStudent());
        studentMap.put(all.getStudent().getId(), studentDTO);
    }
    if(all.getPhone() != null) {
        studentDTO.getPhones().add(all.getPhone());
    }
    studentDTO.setLocation(all.getLocation());
}

List<StudentDTO> studentDTOs = new ArrayList<>(studentMap.values());