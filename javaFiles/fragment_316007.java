public class UndoHandler
{
  @Inject
  private Adapter _adapter; 

  @Execute
  public void execute(@Named(IServiceConstants.ACTIVE_PART) final MPart part)
  {
    final ITextOperationTarget opTarget = _adapter.adapt(part.getObject(), ITextOperationTarget.class);

    opTarget.doOperation(ITextOperationTarget.UNDO);
  }  

  @CanExecute
  public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) final MPart part)
  {
    final ITextOperationTarget opTarget = _adapter.adapt(part.getObject(), ITextOperationTarget.class);
    if (opTarget == null)
      return false;

    return opTarget.canDoOperation(ITextOperationTarget.UNDO);
  }
}