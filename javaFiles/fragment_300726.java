List<Tienda> tiendas = saxparser.parse();
Iterator it = tienda.iterator();
while (it.hasNext()) {
    Tienda temp = it.Next();
    system.out.println(temp.latitude + ", " + temp.longitude + ", " + temp.longitude);
}