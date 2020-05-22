public class PurchaseOrderWrapper {
    private List<Map<String, String>> list = new ArrayList<>();

    public boolean containsElementWithSamePartNoAs(Map<String, String> map) {
        // iterate over the list and find if an element has the same part_no
        // as the map passed as argument
    }

    public void removeElementWithSamePartNoAs(Map<String, String> map) {
        // iterate over the list and find the element which has the same part_no
        // as the map passed as argument. Once found, remove this element from the list
    }
}