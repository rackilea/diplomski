String selectQuery =
        " SELECT *\n" +
        " FROM tableassign\n" +
        " LEFT JOIN tableacc ON tableassign.signeeid = tableacc.userid\n" +
        " LEFT JOIN tableinfo ON tableassign.signeeid = tableinfo.userid\n" +
        " WHERE tableassign.signeedepid =?";
Cursor data = db.rawQuery(selectQuery , new String[]{ signeedep });