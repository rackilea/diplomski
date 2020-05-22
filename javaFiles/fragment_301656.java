public class Bus {  
      int noOfSeats;  
      String busColor;  

      public Bus() {  
           this(40); //// Using another constructor and proceeding with default values..   
      }  
      public Bus(int seats) {   
           this(seats,"red"); // Using another constructor and proceeding..   
      }  
      public Bus(int seats, String color) {  
           this.noOfSeats = seats; 
           this.busColor = color;  
      }  
 }