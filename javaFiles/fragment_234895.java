query {
    getVehicle(maxSpeed: 10) {
        maxSpeed
        ... on Airplane {
        wingspan
      }
        ... on Car {
        licensePlate
      }
    }
}