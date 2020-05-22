public interface Command{
    void execute();
}
public class MoveRightCommand implements Command {
   private Grid theGrid;
   private Player thePlayer;

   public MoveRightCommand(Player player, Grid grid){
        this.theGrid = grid;
        this.thePlayer = player;
       }

   public void execute(){
     player.modifyPosition(0, 1, 0, 0);
   } 
}