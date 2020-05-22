StudentInfoDTO smallest = null;
    for (StudentInfoDTO current : studentInfoDTO) {
        if (smallest == null || current.getMarks() < smallest.getMarks()) {
            smallest = current;
        }
    }