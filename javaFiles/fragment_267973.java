public enum Role {
     ROLE1(1), ROLE2(2), ROLE(3);

     private final int id;
     private Role(int id) {
         this.id=id;
     }

     public int getId() {
          return this.id;
     }
}