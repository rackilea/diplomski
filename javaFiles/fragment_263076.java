while (true) {
            MList<Fax> delList = new MList<>(Fax.class, //
                    "CREATE_DATE < ? " //
                            + "order by CREATE_DATE " //
                            + "offset 0 rows " //
                            + "fetch next 5000 rows ONLY", //
                    limitDate);
            if (delList.size() == 0) {
                break;
            }