public BusinessLogic()
    {
        this.daoLayer = DAOFactory.create(true);
    }

class DAOFactory
{
    public static DAOLayer create(bool isDB)
    {
        DAOLayer aDao;

        if(isDB)
        {
            aDao = // create for DB
        }
        else
        {
            aDao = // create for file
        }

        return aDao;
    }
}