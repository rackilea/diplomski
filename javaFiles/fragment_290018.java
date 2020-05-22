public void createUpdate(Tsaleline entity) {
    //Insert
    String sql = "Insert into tSaleLine (CenterId, ProductId, Price, VATRate) "
            + "Select :centerId, :productId, :price, :vatrate "
            + "where not exists (Select * from tSaleLine where CenterId = :centerId and ProductId = :productId); "
            //Update
            + "Update tSaleLine "
            + "set Price = :price, "
            + "VATRate = :vatrate "
            + "where CenterId = :centerId and ProductId = :productId; ";

    Query q = getEntityManager().createNativeQuery(sql);

            q.setParameter("centerId", entity.getCenterId())
            .setParameter("productId", entity.getProductId())
            .setParameter("price", entity.getPrice())
            .setParameter("vatrate", entity.getVATRate())
            .executeUpdate();
}