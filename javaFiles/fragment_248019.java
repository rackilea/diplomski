StringBuilder grade = new StringBuilder();

while (...) {
    // Add columns from array
    grade
        .append(array4[2]).append(" ")
        .append(array4[3]).append(" ")
        .append(array4[4]);

    // End line
    grade.append("\n");
}

out.println(grade.toString());