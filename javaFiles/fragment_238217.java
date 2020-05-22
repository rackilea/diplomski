Sucursal newSucursal = new Sucursal();
    newSucursal.setSubgerente("ABC");

    int size = 2;
    for (int i = 0; i < size; i++) {

        Producto p = new Producto();
        p.setDescripcion("Description " + i);

        //add associations
        Categoria categoria = em.find(Categoria.class, 1);
        p.setCategoria(categoria);
        Subcategoria subCategoria = em.find(Subcategoria.class, 1);
        p.setSubcategoria(subCategoria);

        //add to new sucursal
        newSucursal.addProduct(p);
    }

    sucursalDAO.save(newSucursal);