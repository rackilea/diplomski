String selectQuery =
        " select *" +
        "    from tableassign left outer join\n" +
        "         tableacc\n" +
        "         on tableassign.signeeid = tableacc.userid left outer join\n" +
        "         tableinfo\n" +
        "         on tableassign.signeeid = tableinfo.userid\n" +
                " WHERE tableassign.signeedepid =?";
Cursor data = db.rawQuery(selectQuery , new String[]{ signeedep });