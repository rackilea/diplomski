public int getProductSellPriceById(int productId) throws SQLException, NoSuchElementException {
    try (Connection currentCon = ConnectionManager.getConnection();
         PreparedStatement ps = currentCon.prepareStatement("select product_sell_price from products where product_id=?")) {

        ps.setInt(1, productId);

        try (ResultSet rs = ps.executeQuery()) { 
            if (rs.next()) {
                return Integer.parseInt(rs.getString("product_sell_price"));
            }
        }
    }

    throw new NoSuchElementException(String.format("No product with id %d found", productId));
}