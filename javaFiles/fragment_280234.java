public static void paidOrder(List<PaidOrder> listPaidOrder, String address){
    try(Connection conn = DBConnectionUtil.getConnection()) {

       String sql="INSERT INTO paid_orders(pname,quantity,price,status,user_email,address) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql); 

        for(PaidOrder o:listPaidOrder){
            ps.setString(1, o.getPname());
            ps.setString(2, o.getQuantity());
            ps.setString(3, o.getPrice());
            ps.setString(4, o.getStatus());
            ps.setString(5, o.getUser_email());
            ps.setString(6, address);            
            ps.executeUpdate();
        }

     } catch (Exception e){
        System.out.println("OrderDAO error"+ e.getMessage());
    }
}