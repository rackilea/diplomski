@Override
public void init() {
    // you are missing this line
    Choice Product = new Choice();
    //
    String[] ProductList = new String[4];
    ProductList[0]="Pen";
    ProductList[1]="Pencil";
    ProductList[2]="Eraser";
    ProductList[3]="NoteBook";

    for(int i=0;i<ProductList.length;i++)
    {
        Product.insert(ProductList[i], i);
    }

    add(Product);
    add(l1);
    Product.addItemListener(this);
}