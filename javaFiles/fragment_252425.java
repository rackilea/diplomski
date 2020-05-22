@OpenApi(
   summary = "",
   description = "Lists all customers",
   path = "customers",
   queryParams =
   // ...........
   // ...........
   // etc
)
override fun handle(context: Context) {
   handleGetCustomers(context)
}