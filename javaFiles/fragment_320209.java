// Outside WS function - setup parameters and invoke
String zip = "98682";
Holder<Boolean> result = new Holder<Boolean>();
getSupplierByZipCode(zip, result, ..);

// Then inside the function the Holder is modified and a new value
// is assigned to it's value member.
getSupplierByZipCodeResult.value = true;

// And outside again, the mutations are visibile still
if (result.value) {
    // Yay!
}