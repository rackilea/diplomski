First get the right list you need:
List<String> itemsToRemove = ...getting the list5, from your code I don't understand how the list is holding.

Then you can just iterate in reverse way and remove.
for (int i = middle_group_table.getItemCount() - 1; i <= 0; i--)
{
    if (itemsToRemove.contains(items[i].getText()))
        middle_group_table.remove(i);
}