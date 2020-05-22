public String findAverage(double di, double dj, double dk) { 
          average = (di + dj + dk) / 3.0; 
          return returnAverage();
       }

       public String returnAverage() {
          return "average = " + average;
       }