public Business addBusiness(String person, String business, String location) 
{
int id = 0;

for (Business business : businesses ) {
    if (business.getPerson().equals(person)) {
        if (business.getBusiness().equals(business)) {
            if (business.getLocation().equals(location)) {
                return null;
            }
        }
    }
}
Business newBusiness = new Business(person, business, location, id);
return newBusiness;
}