public Business addBusiness(String person, String business, String location) 
{
int id = 0;

for (Business b : businesses ) {
    if (b.getPerson().equals(person)) {
        if (b.getBusiness().equals(business)) {
            if (b.getLocation().equals(location)) {
                return null;
            }
        }
    }
}
Business newBusiness = new Business(person, business, location, id);
b.add(newBusiness); // This was the missing line, now it seems to work fine.
return newBusiness;
}