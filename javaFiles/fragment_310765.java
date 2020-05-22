private void cmd_sendActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try{
        JSONObject obj = new JSONObject();
        obj.put("user_id",user_id_text.getText());
        obj.put("password",password_text.getText());

        String kirim = obj.toString();
        SendtoAndroid st=new SendtoAndroid();
        st.setName(kirim);
        st.startServer();

    }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
    }

}