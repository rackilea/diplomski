public class CardHolder {
    private LendingItem[] lendingItems;

    public CardHolder () {
        lendingItems = new LendingItem[0];
    }

    public boolean signOut(LendingItem item) {
        if (lendingItems.length >= 7) return false;
        lendingItems = Arrays.copyOf(lendingItems, lendingItems.length + 1); //copies old array, but adding a null value to the new one
        lendingItems[lendingItems.length - 1] = item; //replace the null value with the new item to add
        return true;
    }

    public LendingItem[] getSignedOutItems() {
        return lendingItems;
    }
}