class USPresident implements Serializable {

   private static final long serialVersionUID = 1L;

   @Override
   public String toString() {
      return "US President [name=" + name + ", period=" + period + ", term="
            + term + "]";
   }

   public USPresident(String name, String period, String term) {
      this.name = name;
      this.period = period;
      this.term = term;
   }

   private String name;
   private String period;
   private static transient String term;
}

class TransientSerialization {

   public static void main(String[] args) {
      serializePresident();
      deserializePresident();
   }

   private static void deserializePresident() {
      ObjectInputStream ois = null;
      try {
         ois = new ObjectInputStream(new FileInputStream(
               "USPresident.data"));
         Object obj = ois.readObject();
         if (obj != null && obj instanceof USPresident) {
            USPresident presidentOfUS = (USPresident) obj;
            System.out.println(presidentOfUS);

         }
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } finally {
         if (ois != null) {
            try {
               ois.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   private static void serializePresident() {
      USPresident usPresident = new USPresident("Barack Obama", "2009 to --",
            "56th term");
      System.out.println(usPresident);
      ObjectOutputStream oos = null;
      try {
         oos = new ObjectOutputStream(new FileOutputStream("USPresident.data"));
         oos.writeObject(usPresident);
         oos.close();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } finally {
         if (oos != null) {
            try {
               oos.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }
}