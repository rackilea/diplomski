public class Tester {
      public static void main(String[] args) {
            Product p = new Product();
            PO po = new PO();

            List<PO> pos = new ArrayList<PO>();
            List<POL> pols = new ArrayList<POL>();

            attachChildToParent(pos, p);
            attachChildToParent(pols, po);
        }

    private static <C extends CMS<?>> void attachChildToParent(List<C> childNodes, CMS<C> parent) {
        for (C childNode : childNodes) {
            parent.attach(childNode);
        }
    }
}