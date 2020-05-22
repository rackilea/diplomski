interface Item { /* methods omitted */ }

interface SimpleItem extends Item { /* methods omitted */ }

interface ContainerItem extends Item { /* methods omitted */ }

// telling clients that this can throw an exception or not
// here is a whole different design question :)
interface ItemVisitor { void visit(Item i) /* throws Exception */; }

class MyVisitor implements ItemVisitor {
  void visit(Item i) {
    if (i instanceof SimpleItem) {
      // handle simple items
    } else if (i instanceof ContainerItem) {
      // handle containers using container specific methods
    } else {
      // either throw or ignore, depending on the specifications
    }
  }
}