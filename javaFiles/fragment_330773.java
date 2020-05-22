List<Supplier> list = new ArrayList<Supplier>();
int number = ss.maxNum(supplier);
for (int i = 0; i < 5; i++) {
    Supplier supplier = new Supplier();
    supplier.setNum(number + i);
    supplier.setName("supplier" + i);
    supplier.setDel("n");
    supplier.setAddr("address" + i);

    list.add(supplier);
    System.out.println(i + " : " + supplier);
}