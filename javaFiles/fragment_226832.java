StudentInfoDTO smallest = null;
    for (int i = 0; i < studentInfoDTO.size(); i++) {
        StudentInfoDTO current = studentInfoDTO.get(i);
        if (smallest == null || current.getMarks() < smallest.getMarks() ) {
            smallest = current;
        }
    }