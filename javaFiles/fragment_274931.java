String gradeList = "5 - 90 85 95.5 77.5 88";
String gradeArray [] = gradeList.split(" ");
int firstElement = Integer.parseInt(gradeArray[0]);
double gradeDoubleArray [] = new double[firstElement];
for(int i = 2; i < firstElement + 2; i++){
    gradeDoubleArray[i-2] = Double.parseDouble(gradeArray[i]);
}