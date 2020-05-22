TestData {
   String status;
   String billType;

   public boolean equals(Object obj) { 
      if (obj == null || !(obj instanceof Testdata)) return false;
      TestData other = (TestData) obj;

      return status.equals(other.getStatus()) && billType.equals(other.getBillType())
   }

   public int hashCode() {
      int hashcode = 31;
      hashcode += 31 * status.length();
      hashcode += 31 * billType.length();
      return hashcode;
   }
}