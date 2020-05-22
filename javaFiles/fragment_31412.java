public class KnightOfTheRoundTable implements Knight {
   …
   private Minstrel minstrel;
   public void setMinstrel(Minstrel minstrel) {
      this.minstrel = minstrel;
   } 
   …
   public HolyGrail embarkOnQuest() throws QuestFailedException {
      minstrel.singBefore(this);
      HolyGrail grail = quest.embark();       
      minstrel.singAfter(this);

      return grail;
   }
}