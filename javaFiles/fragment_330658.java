public class Segment
{
   private Long ts;
   private Long seg_type;
   private Long area_type;

   public pgType(){
      return String.format("\"(%d,%d,%d)\"",
         this.ts, this.seg_type, this.area_type)
   }
}