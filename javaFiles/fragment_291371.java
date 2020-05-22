for(Resort re: resortList)
{
    if ( re.getResortCode().equals(resortCode))
        System.out.println(re.toString());
}

Rental r1 = new Rental(guestList.get(2),resortList.get(3));