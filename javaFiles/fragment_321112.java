String sql = "SELECT *" +
              " FROM " + tabla +
          " ORDER BY fechatotal DESC";
try (FileWriter writer = new FileWriter(file)) {
    writer.write("fecha" +
                ",hora" +
                ",fechatotal" +
                ",temperatura" +
                ",humedad" +
                ",luminosidad");
    try (ResultSet resultado = st.executeQuery(sql)) {
        writer.write("\n" + resultado.getDate("fecha") +
                      "," + resultado.getTime("hora") +
                      "," + resultado.getTimestamp("fechatotal") +
                      "," + resultado.getDouble("temperatura") +
                      "," + resultado.getDouble("humedad") +
                      "," + resultado.getDouble("luminosidad"));
    }
}