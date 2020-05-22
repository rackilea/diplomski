class Boy {
   private Dog dog;

   public Boy(Dog dog) {
      this.dog = dog;
   }

   public String getDogName() {
      return dog.getName();
   }
}