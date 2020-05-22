public List<CustomObject> getTypePlan(int id) throws Exception {
        List<CustomObject> type = new ArrayList<>();
        try {
            Connection conn = AppConnection.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call SP_LEER_PFI_TIPOS_PLANES(?)}");
            cstmt.setInt(1, id);
            ResultSet results = cstmt.executeQuery();
            while (results.next()) {
                int cod_plan = results.getInt("cod_plan");
                String des_plan = results.getString("des_plan");
                int can_dias_plazo = results.getInt("can_dias_plazo");

                CustomObject listObject = new CustomObject();
                listObject.setCodPlan(cod_plan);
                listObject.setDesPlan(des_plan);
                listObject.setCanDiasPlazo(can_dias_plazo);

                type.add(listObject);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return type;
    }