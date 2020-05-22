abstract class Action {
  public void perform();
}


public class CutHairsAction {

 Human agent,target;

 public  CutHairsAction(Human agent, Human target) {
   if (agent.getHolding() == null) throw new IllegalStateException("agent not holding scissors"); 
   if (! agent.getHolding() instanceOf Scissor) throw new IllegalStateException("agent not holding scissors"); 
 if (target.Hair.lenght < 5) throw new IllegalStateException("target hair short enough"); 

   this.target = target;
   this.agent = agent;
 }

 public void perform() {
 target.Hair.length = 5;
 }
}