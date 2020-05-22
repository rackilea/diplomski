//make variable instances
var BO = TheApplication().GetBusObject("Base");
var bcCat = BO.GetBusComp("Category list");
var bcProd = BO.GetBusComp("Product  list");

//search for category

bcCat.ClearToQuery();
bcCat.SetSearchSpec("Id", "1-234");
bcCat.ExecuteQuery(True);

// When using the ExecuteQuery method with Java Data Bean, use True for //ForwardOnly and False for ForwardBackward.

if (bcCat.FirstRecord())
{
//the link will automatically filter and bring only those products for this //category

    bcProd.ClearToQuery();
    bcProd.ExecuteQuery(True);
}