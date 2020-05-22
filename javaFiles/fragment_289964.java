fun getFilledData(account: Account): Account {

    account.OrganizationName = "name"

    val addresses = ArrayList<Address>()
    for(i in 0..10){

        //create and  insert your multiple addresses here
        val address  = Address(i,"name $i","line1 $i","line2 $i ","city $i","locality $i","state $i ", i)

        addresses.add(address)
    }
    //assign list to account
    account.Addresses = addresses

    return account
}