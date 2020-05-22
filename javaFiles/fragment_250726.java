while (rs.next()) {

    Logs log = new Logs();

    log.setID(rs.getLong("ID"));

    log.setAddress(rs.getString("address"));

    log.setDescription(rs.getString("description"));

    log.setActionDate(rs.getTimestamp("actionTime"));

    logs.add(log);

}