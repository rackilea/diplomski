public List<T> read (T t) {

    List<AddressData> addresses = new ArrayList<AddressData>();

    if (t instanceof AddressData) {
        try {
            if (dbConnect.getConnectionStatus()) {
                connection = dbConnect.openConnection();

            } else {
                throw new InstantiationException();
            }

            preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM AddressData");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AddressData a = new AddressData();
                a.setAddressId("addressId"));
                a.setAddressLine1(resultSet.getString("addressLine1"));
                a.setAddressLine2(resultSet.getString("addressLine2"));
                a.setCity(resultSet.getString("city"));
                a.setState(resultSet.getString("state"));
                a.setCountry(resultSet.getString("country"));
                a.setPinCode(resultSet.getString("pinCode"));

                addresses.add(a);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;

    } else {
        // ...?
    }

}