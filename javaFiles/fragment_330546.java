String input1=// got from user
    String input2=// got from user
    Query query = session.createQuery("from Osoba WHERE (zainteresowania LIKE ?) and (zainteresowania LIKE ?)")
.setString(0,"%"+input1+"%")
.setString(1,"%"+input2+"%")
.list();