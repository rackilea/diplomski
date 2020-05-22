ArrayList<Extcteach> extcteachList = new ArrayList<Extcteach>();
while(resultset .next()) {
        Extcteach extcteach = new Extcteach ();

        extcteach.setAttr1 = (result.getString("column1")
        extcteach.setAttr2 = (result.getString("column2")

        /****THIS FOR EACH COLUMN OF YOUR TABLE****/

        extcteachList.put(extcteach) 
    }