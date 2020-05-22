import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCamera {
   public static void main(String[] args) {
      ArrayList<MyCamera> cameraList = new ArrayList<>();

      // We'll pretent to use Scanner here to get values

      cameraList.add(new MyCamera("Sony", 8, 250.00));
      cameraList.add(new MyCamera("Olympus", 7, 450.0));
      cameraList.add(new MyCamera("Nikon", 10, 400.0));
      cameraList.add(new MyCamera("Fuji", 7, 450.50));

      System.out.println("Pre-sorted list:");
      for (MyCamera myCamera : cameraList) {
         System.out.println(myCamera);
      }
      System.out.println();      
      System.out.println("Post-sorted list:");
      Collections.sort(cameraList, new MyCameraComparator(false));
      for (MyCamera myCamera : cameraList) {
         System.out.println(myCamera);
      }

   }
}

class MyCamera {
   private int rating;
   private double cost;
   private String name;

   public MyCamera(String name, int rating, double cost) {
      this.name = name;
      this.rating = rating;
      this.cost = cost;
   }

   public String getName() {
      return name;
   }

   public int getRating() {
      return rating;
   }

   public double getCost() {
      return cost;
   }

   @Override
   public String toString() {
      return "MyCamera [rating=" + rating + ", cost=" + cost + ", name=" + name
            + "]";
   }

}

class MyCameraComparator implements Comparator<MyCamera> {
   private boolean lowestToHighest = true;

   public MyCameraComparator() {
      // default constructor
   }

   public MyCameraComparator(boolean lowestToHighest) {
      this.lowestToHighest = lowestToHighest;
   }

   @Override
   public int compare(MyCamera cam1, MyCamera cam2) {
      int finalResult = 0;
      int ratingValue = Integer.compare(cam1.getRating(), cam2.getRating());
      if (ratingValue != 0) {
         finalResult = ratingValue;
      } else {
         finalResult = Double.compare(cam1.getCost(), cam2.getCost());
      }

      if (lowestToHighest) {
         return finalResult;
      } else {
         return -finalResult;
      }
   }
}