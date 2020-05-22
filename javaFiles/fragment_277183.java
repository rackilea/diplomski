@SuppressWarnings("unchecked")
    public List <Data> getDetails(String tin) {
        List <Data> dataList = new ArrayList<>();
        List <Data> results = sessionFactory.getCurrentSession().createQuery("from Data where cal_no = :cal_no")
                .setParameter("cal_no",  tin).list();
        if(CollectionUtils.isNotEmpty(results){
            Data firstDataOccurence = results.get(0);
            dataList.add(firstDataOccurence);
            return dataList;
        }
        else{
            return ListUtils.EMPTY_LIST;
        }
    }