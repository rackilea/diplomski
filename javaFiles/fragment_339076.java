public enum SchoolEnum {
   Kannic("immnunekannic");
   private String immune;
   public SchoolEnum (String immune) {this.immune = immune;}
   public ImmuneEnum getImmune() {
       return ImmuneEnum.valueOf(immune);
   }
}

public enum ImmnueEnum {
   immunekannic("Kannic");
   private String scholl;
   public ImmnueEnum (String school) {this.school = school;}
   public SchoolEnum getSchool() {
       return SchoolEnum.valueOf(school);
   }
}