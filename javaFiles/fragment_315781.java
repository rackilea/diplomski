public String calculateGrade(int mark) {
    if (mark < 0 || mark > 100) {
        return "Invalid mark";
    }
    if (mark < 40) {
        return "Fail"; 
    }
    if (mark < 50) {
        return "3rd";
    }
    if (mark < 60) {
        return "2ii";
    }
    if (mark < 70) {
        return "2i";
    }
    return "1st"; 
}