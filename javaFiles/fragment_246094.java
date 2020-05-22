public List<Object[]> getCities(Integer stateId)  {
        List<Object[]> cityList = new ArrayList<Object[]>();
        String query = "select city.cityId,city.cityName from City city where city.state.stateId=?";
        Object[] queryParam = {stateId};
        cityList = getHibernateTemplate().find(query, queryParam);
        return cityList;
    }