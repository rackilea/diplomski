boolean oops;
int retries = 5;
Connection c = null;
Statement s = null;
ResultSet rs = null;    

do
{
    oops = false;
    c = null;
    s = null;
    rs = null;
    try
    {
        c = openConnection();
        s = c.createStatement();
        rs = s.executeQuery("SELECT stuff FROM mytable");
        fiddleWith(rs);
    }
    catch (SQLException sqlex)
    {
        oops = true;
        switch(sqlex.getErrorCode()())
        {
            case MysqlErrorNumbers.ER_LOCK_DEADLOCK:
                // deadlock or lock-wait time-out occured
                break;
            ...
        }
        Thread.sleep(1000); // short delay before retry
    }
    finally
    {
        if (rs != null) try {
            rs.close();
        } catch (SQLException e) {
            // some error handler here
        }

        if (s != null) try {
            s.close();
        } catch (SQLException e) {
            // some error handler here
        }

        if (c != null) try {
            c.close();
        } catch (SQLException e) {
            // some error handler here
        }

    }
}
while (oops == true && retries-- > 0);