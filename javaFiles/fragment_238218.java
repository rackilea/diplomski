@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "sucursal")
private List<Producto> producto = new ArrayList<>();

public void addProduct(Producto p) {
    p.setSucursal(this);
    this.producto.add(p);
}