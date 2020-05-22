public class MyThing {
     private long uniqueID;
     private String attr1;
     private String attr2;
     private String attr3;
     // ++ rest of attriutes, getters and setters  
}

public MyThing getMyThing(long uniqueID) {
    // code to retrieve MyThing from table1, poulating all attributes
}

public void updateMyThing(MyThing myThing) {
    PreparedStatement pst = Connection.prepareStatement
        (" UPDATE table1 SET attr1 = ?, attr2 = ?, attr3 = ?, attr4 = ?, attr5 = ?" +
         " WHERE id = ? );
    pst.SetString(1, myThing.getAttr1());
    pst.SetString(2, myThing.getAttr2());
    pst.SetString(3, myThing.getAttr3());
    pst.SetString(4, myThing.getAttr4());
    pst.SetString(5, myThing.getAttr5());
    pst.SetString(6, myThing.getId());

    // etc.
}