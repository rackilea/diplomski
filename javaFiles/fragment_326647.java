public class FairScheduler extends Scheduler {

    private static int index = 0;

    @Override
    /** removes a given action from the scheduler
     * @param action the action to remove
     */
    public void removeAction(Action action) {
        this.theActions.remove(action);
    }

    /** returns the nextAction in the scheduler, 
     * if the current action is the last element of the scheduler
     * the first action of the scheduler is returned instead
     * 
     * @return an Action, the next in the scheduler from given index
     */
    @Override
    protected Action nextAction() {
        if (!theActions.isEmpty()) {
            if (index >= theActions.size()){
                index = 0;
            }
            return theActions.get(index++);
        }
    }

}