class Employee {
       private String name;
       private int code;

   // constructor
   public Employee(String name, int code) {
      this.name = name;
      this.code = code;
   }

       // getter
       public String getName() { return name; }
       public int getCode() { return code; }
       // setter

       public void setName(String name) { this.name = name; }
       public void setCode(int code) { this.code = code; }
    }