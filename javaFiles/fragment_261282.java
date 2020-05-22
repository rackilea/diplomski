public class Converter {

    private List<Converter> converters;

    public Converter() {

    }

    public Converter(List<Converter> converters) {
        this.converters = converters;
    }

    public void execute(Product product) {
        for (Converter converter : converters) {
            converter.execute(product);
        }
    }

}

public class BConverter extends Converter {

    @Override
    public void execute(Product product) {
        if (product.getClass() == BProduct.class) {
            innerExecute((BProduct)product);
        } else {
            innerExecute(product);
        }
    }

    public void innerExecute(Product product) {
        System.out.println(product.get() + " done on B normal.");
    }

    public void innerExecute(BProduct b) {
        System.out.println(b.getB() + " done on B special.");
    }

}

public class CConverter extends Converter {

    @Override
    public void execute(Product product) {
        if (product.getClass() == CProduct.class) {
            innerExecute((CProduct)product);
        } else {
            innerExecute(product);
        }
    }

    public void innerExecute(Product product) {
        System.out.println(product.get() + " done on C normal.");
    }

    public void innerExecute(CProduct b) {
        System.out.println(b.getC() + " done on C special.");
    }

}