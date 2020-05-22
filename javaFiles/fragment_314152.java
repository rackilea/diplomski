int rowsMatched = ps.executeUpdate();
if(rowsMatched == 0) {
    try {
        insert into UNIQUE_NUMBER (number, qty) values(?, 0)
    } catch(Exception e) {
        // the insert will fail if another thread has already
        // inserted the same number. check if that's the case
        // and if so, increment instead.
        if(isCauseUniqueConstraint(e)) {
            update UNIQUE_NUMBER set qty = qty + 1 where number = ?
        } else {throw e;}
    }
}