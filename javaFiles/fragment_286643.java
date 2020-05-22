@SuppressWarnings("unchecked")
    @Transactional
    public List<BMI> listBMIpat(int patId){
        Session s = this.sf.getCurrentSession();
        List<BMI> bmis = (List<BMI>) s.createSQLQuery("Select * from BMI B where patient_id = "+patId).list();
        return bmis;
    }