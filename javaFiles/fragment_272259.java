if ((gpa >= 4.0 && sat >= 1100) || (gpa >= 3.5 && sat >= 1300) ||
        (gpa >= 3.0 && sat >= 1500) || highestHonors.equalsIgnoreCase("y")) {
    studentQualified();
} else {
    unQualified();
}