public String toString() {
  String str=""; // FOR LOOP??? 

  if(grade[0]!=null)
  str += "Lab Score: " + grade[0].getScore() + ", Grade: " + grade[0].getGrade() + "\n";
  if(grade[1]!=null)
  str +=   "Pass/Fail Exam Score: " + grade[1].getScore() + ", Grade: " + grade[1].getGrade() ;
  if(grade[2]!=null)
  str +=   "Essay Score: " + grade[2].getScore() + ", Grade: " + grade[2].getGrade() + "\n" ;
  if(grade[3]!=null)
    str +=  "Final Exam Score: " + grade[3].getScore() + ", Grade: " + grade[3].getGrade();

  return str;
}