try
    {
        List<Holidays> holidayDetails = getHibernateTemplate().find("from Holidays where holidayId = 1");
        return holidayDetails;
    }
    catch(Exception e)
    {
        e.printStackTrace();
        return null;
    }