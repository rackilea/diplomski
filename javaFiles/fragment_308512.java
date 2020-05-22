@Override
public boolean equals(Object obj) {    // Overriding "equals()".
    // at first check if objects are the same -> your code
    if (this == obj) {
        return true;
    }

    // secondly we chack if objects are instances of the same class if not return false
    if (obj != null && this.getClass() != obj.getClass()) {
        return false;
    }

    // then compare objects fields. If fields have the same values we can say that objects are equal.
    Product product = (Product) obj;
    return this.name.equals(product.name) && this.price.equals(product.price);
}