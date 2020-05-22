Employee.createCriteria().list() {
  projections {
    userEmployees {
      eq('user', someUser)
    }
  }
}