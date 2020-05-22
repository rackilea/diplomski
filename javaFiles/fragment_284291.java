type Query {
    allCars(filter: CarsFilter!): [Car]
}


input CarsFilter {
    color: String!
    brand: String!
}