try (IDocumentSession sesion = store.openSession()) {
    CountryLayerCount c1 = new CountryLayerCount();
    c1.layerCount = 5;
    c1.countryName = "Germany";

    sesion.store(c1);
    sesion.saveChanges();
}