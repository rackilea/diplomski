public class Main {
    public static void main(String[] args) {
        java.util.List<Item> inputItems = createInputItems();
        java.util.List<Item> oututItems = processItemsToParentChildren(inputItems);

        System.out.println(oututItems);     
    }