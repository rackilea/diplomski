public class TestMarathonRunner {

public static void main(String[] args) {

int times[] = { 341, 273, 278, 329, 445, 275, 275, 243, 334, 412, 
  393, 299, 343, 317, 265 };

System.out.println("The average time is: " +
     MarathonRunner.getAverageTime(times));

MarathonRunner.getAboveAverage(times);