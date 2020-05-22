String avgGrade = "";
if (average < 60)
    avgGrade = "F";
else if (average < 70)
    avgGrade = "D";
else if (average < 80)
    avgGrade = "C";
else if (average < 90)
    avgGrade = "B";
else
    avgGrade = "A";

JOptionPane.showMessageDialog(null, "The grade for "+ average + "% is "+avgGrade+".");