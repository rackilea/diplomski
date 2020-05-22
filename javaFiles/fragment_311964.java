String updq2;
    bool isNull = false;
    //If your data is null and you want to set it null use this 
    if(yourDate == null)
    {
        updq2 = "update TblUser a set loggedStatus = ? ,lockedStatus= ?,currentAttempts = ?,logoutDate = NULL where upper(a.id)=?";//,lockedStatus= ?, currentAttempts = ?, logoutDate = ? where upper(a.id) = ?";
        isNull = true;
    } //If it isn't null and you want to set and value use this
    else
    {
        updq2 = "update TblUser a set loggedStatus = ? ,lockedStatus= ?,currentAttempts = ?,logoutDate = ? where upper(a.id)=?";//,lockedStatus= ?, currentAttempts = ?, logoutDate = ? where upper(a.id) = ?";

    } 

    Session newSession2=factory.openSession();
    Transaction tx1=newSession2.beginTransaction();
    Query query =newSession2.createQuery(updq2);
    query.setParameter(0, (byte)9);
    query.setParameter(1,"1" );
    query.setParameter(2, 0);

    if(isNull)
    {
         query.setParameter(3,  userName.toUpperCase());
    }
    else
    {
         query.setParameter(3, yourDataHere);
         query.setParameter(4,  userName.toUpperCase());
    }