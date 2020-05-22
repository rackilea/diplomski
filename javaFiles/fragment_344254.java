while(sc1.hasNext())
{
    // First case where the list is empty
    if (cl1.getSize() == 0)
    {
        S = sc1.next();
        serialNum = Long.parseLong(S);
        S = sc1.next();
        brand = S;
        S = sc1.next();
        price = Double.parseDouble(S);
        S = sc1.next();
        year = Integer.parseInt(S);

        CellPhone c1 = new CellPhone(serialNum, brand, year, price);
        cl1.addToStart(c1);
    }
    else
    {
        S = sc1.next();
        serialNum = Long.parseLong(S);
        S = sc1.next();
        brand = S;
        S = sc1.next();
        price = Double.parseDouble(S);
        S = sc1.next();
        year = Integer.parseInt(S);

        if (!(cl1.contains(serialNum)))
        {
            CellPhone c2 = new CellPhone(serialNum, brand, year, price);
            cl1.addToStart(c2);
        }
    }
}