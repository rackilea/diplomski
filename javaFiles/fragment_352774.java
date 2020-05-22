public class MyClass {
    public static void main(String args[]) {
        String oldString = "This,Is,A,Test";
        String[] oldItems = oldString.split(",");

        String newString = "This,Is,A,New";
        String[] newItems = newString.split(",");

        // For each new item, check all old items
        for (String newItem: newItems)
        {
            Boolean foundItem = false;
            for (String oldItem: oldItems)
            {
                // Item was already in the old items
                if (newItem.equals(oldItem))
                {
                    foundItem = true;
                    break;
                }
            }
            // New item is not in the old list of items
            if (!foundItem)
            {
                System.out.println("New item added: " + newItem);
            }
        }
    }
}