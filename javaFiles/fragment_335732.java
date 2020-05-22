if(isUserDeleted())
{
 if(deleteCompletedCallback != null)
    {
      deleteCompletedCallback.onDeleteCompleted();
    }
}