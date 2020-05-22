public void loading() {
    try {
        String[]title = {"First Name","Last Name","Picture"};
        String sql="select * from users";
        model = new DefaultTableModel(null,title){
            @Override
            public Class<?> getColumnClass(int column) {
                if (column==2) return ImageIcon.class;
                return Object.class;
            }
        }
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Object[]fila = new Object[4];
        while(rs.next()){
            fila[0] = rs.getString("fna");
            fila[1] = rs.getString("lna");
            fila[2] = new ImageIcon(rs.getBytes("pic"));            
            model.addRow(fila);
        }
        tbl.setModel(model);
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}