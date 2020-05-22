public class BetterUpdateListStrategy extends UpdateListStrategy {

    @Override
    protected IStatus doAdd(IObservableList observableList, Object element, int index) {
        IStatus result = super.doAdd(observableList, element, index);
        if (result.isOK()) {
            result = validate(observableList);
        }
        return result;
    }

    // these methods are overridden in exactly the same way: 
    // protected IStatus doMove(IObservableList observableList, int oldIndex, int newIndex)
    // protected IStatus doRemove(IObservableList observableList, int index) 
    // protected IStatus doReplace(IObservableList observableList, int index, Object element) 

    private IStatus validate(IObservableList value) {
        // my validation; I added an IValidator to have a similar API
        // to the UpdateValueStrategy
        return Status.OK_STATUS;
    }
}