class BusinessLogic
{
    /// ...

    DAOLayer daoLayer;

    public BusinessLogic(DAOLayer daoLayer)
    {
        this.daoLayer = daoLayer;
    }

    /// ...
}

class DAOImpl implements DAOLayer
{
    /// ...
}