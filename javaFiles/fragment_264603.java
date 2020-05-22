Dealership dealershipToDelete = (Dealership) session.load(Dealership.class, idDealership);
Dealership newDealership = (Dealership) session.load(Dealership.class, idNewDealership);
for(Car c: dealershipToDelete.getCars().stream().filter(c -> c.isSold()).toArray(Car[]::new)){   
    c.setDealership(newDealership);
    newDealership.getCars().add(c);
}
session.flush(); //this will flush the updates to sold Car, with the new Dealership details 
session.refresh(dealershipToDelete); //this will load the updated "dealershipToDelete" without the 'Sold Car' object,the 'Unsold' ones will still be there
session.delete(dealershipToDelete); //this will delete the Dealership and its related unsold car objects.

tx.commit();

session.close();