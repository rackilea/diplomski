@Override
public String toString() {
    if (product.checkProductNumber()) {
        return "number='" + product.getProductNumber() + 
               ", locale=" + locale;
    } else {
        return super.toString();
    }
}