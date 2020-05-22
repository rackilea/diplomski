public String calculateGrade(int mark) {
    String grade; // ** Note I don't do = ""; I want the compiler to warn me if I try to use it without assigning to it

    if (mark < 0 || mark > 100) {
        grade = "Invalid mark";
    }
    else if (mark < 40) {
        grade = "Fail"; 
    }
    else if (mark < 50) {
        grade = "3rd";
    }
    else if (mark < 60) {
        grade = "2ii";
    }
    else if (mark < 70) {
        grade = "2i";
    }
    else {
        grade = "1st"; 
    }
    return grade;
}