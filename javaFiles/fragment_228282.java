public class RandomAction implements Controller {
    Action action = new Action();
    Random rand = new Random();
    long updatedAt;

    public RandomAction() {
        updateAction(); // do first init
    }

    @Override
    public Action action() {            
        if (System.currentTimeMillis() - updatedAt > 1000) {
            updateAction();
        }            
        return action;
    }

    private void updateAction() {
        action.shoot = rand.nextBoolean();
        action.thrust = rand.nextInt(2);
        action.turn = rand.nextInt(3) - 1;
        updatedAt = System.currentTimeMillis();
    }
}