public class Test
{
    public Test()
    {
        ListView<Object> myListView = new ListView<>();
        myListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        myListView.getSelectionModel().getSelectedItems().addListener(this::onSelectionChange);
    }

    private void onSelectionChange(ListChangeListener.Change<? extends Object> change)
    {
        // Use the complete List to Update everything you need:
        List<? extends Object> selection = change.getList(); // List of all selected Items

        // OR  use the Change to only update the Things that have been changed:
        while (change.next())
        {
            if (change.wasPermutated())
            {
                for (int i = change.getFrom(); i < change.getTo(); i++)
                {
                    //permutate
                }
            }
            else if (change.wasUpdated())
            {
                //update item
            }
            else
            {
                for (Object removedItem : change.getRemoved())
                {
                    // perform remove action
                }

                for (Object addedItem : change.getAddedSubList())
                {
                    // perform add action
                }
            }
        }
    }
}