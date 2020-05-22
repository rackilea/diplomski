for (StatusChangeDB row : listToChange) {

 ArrayList<StatusChangeDB> tempList = new ArrayList();
    for (StatusChangeDB statusChangeDB : originalList) {

        if (statusChangeDB.getSector().equals(row.getSector())
                && statusChangeDB.getSuperlayer().equals(row.getSuperlayer())
                && statusChangeDB.getLoclayer().equals(row.getLoclayer())
                && statusChangeDB.getLocwire().equals(row.getLocwire())) {
            System.out.println("####### EQUAL #######");

            System.out.println(ro.getSector() + "  " + ro.getSuperlayer() + "  " + ro.getLoclayer() + "  "
                    + ro.getLocwire());

  tempList.add(statusChangeDB);

        }


    }

this.originalList.removeAll(tempList);

}