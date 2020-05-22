while (row = resultSet.next()) {
    if (row.locationCode != currentLocation.locationCode) {
        currentLocation = new Location(row.locationCode)
        list.add(currentLocation)
        currentMaterial = null
    } else if (currentMaterial == null ||
               row.materialCode != currentMaterial.materialCode) {
        currentMaterial = new Material(row.materialCode)
        currentLocation.add(currentMaterial)
    } else {
        currentMaterial.add(new Item(row.itemCode, row.vendorCode))
    }
}