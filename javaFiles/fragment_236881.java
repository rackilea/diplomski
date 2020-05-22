public class StudentUtil {

    public static String getDegreeClassification(int averageMarks) {
        String degreeClassification = null;
        if (averageMarks >= 0) {
            if (averageMarks >= 70) {
                degreeClassification = "First";
            } else if (averageMarks >= 60) {
                degreeClassification = "Upper Second";
            } else if (averageMarks >= 50) {
                degreeClassification = "Lower Second";
            } else if (averageMarks >= 40) {
                degreeClassification = "Third";
            } else if (averageMarks >= 30) {
                degreeClassification = "Pass";
            } else {
                degreeClassification = "Fail";
            }
        } else {
            degreeClassification = "Average cannot be less than ZERO";
        }
        return degreeClassification;
    }
}