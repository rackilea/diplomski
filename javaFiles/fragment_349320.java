String query = "INSERT INTO PRODUCTS(product_code, adv_name, category, manufacturer, "
        + "gift_included, product_name, product_desc, product_aff_link, "
        + "product_pic, price_no_vat, price_vat, free_shipping) VALUES(?, ?, ?, ....)";
try (PreparedStatement pstm = getPreparedStatement(query)) {
    pstm.setString(1, PRODUCT_CODE);
    pstm.setString(2, adv_name);
    pstm.setString(3, category);
    ...
    pstm.execute();
    closeStatement(pstm);
}