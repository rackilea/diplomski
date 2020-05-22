class PreChild {
   String name;

   public Child withVersion(int version) {
        return Child(version, name);
   }
}
class Parent {
   int version;
   Child child;

   @JsonCreator
   Parent(
       @JsonProperty("version") int version,
       @JsonProperty("child") PreChild preChild) {
       this.version = version;
       this.child = preChild.withVersion(version);
   }
}