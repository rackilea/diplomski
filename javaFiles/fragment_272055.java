public class BarChartExample {
public static void main(String[] args) {
// Create a simple Bar chart

double[] dub = {12.2, 15.4, 18.3, 9.3, 7.7};    //Array 
String[] student = {"Bob", "Dave", "William", "Boris", "Rick"}; //Array

DefaultCategoryDataset dataset = new DefaultCategoryDataset(); //Create dataset
for(int i = 0; i < dub.length; i++){
dataset.setValue(dub[i], "Marks", student[i]); //Setting the values
}

JFreeChart chart = ChartFactory.createBarChart3D("Goal comparison",
"Marks", "Students", dataset, PlotOrientation.VERTICAL,
false, true, false); //Chart creation
try {
ChartUtilities.saveChartAsJPEG(new File("D:\\Users\\user2777005\\Desktop\\Barchart.jpg"), chart,     500, 300);
} catch (IOException e) {
System.err.println("Problem occurred creating chart.");
}}}