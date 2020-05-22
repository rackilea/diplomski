public class LevelManager{

  private List<Level> levels;

  // constructor
  public LevelManager(){
   levels = new ArrayList<Level>();
   levels.add(new IntroLevel());
   levels.add(new LevelOne());
   ...
  }

}