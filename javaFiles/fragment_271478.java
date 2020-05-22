Class Class1 
    {

     // Populated value to be stored
     private Date utilityStartDate;

    // method called by Class2 to get the populated value
     public Date getUtilityStartDate()
    {
        return utilityStartDate;
     }

   // Method to populated. (Your logic)
   @Override
   public void populateUtility(Date utilityStartDate, String utilityStatus) {
    if(this.Utility != null) {
        this.Utility.populate(utilityStartDate, utilityStatus);
       }
    }

  }

    Class Class2
    {
     private Class1 class1;

     public void setClass1(Class1 class1)
     {
        this.class1 = class1;
     }


    @Loggable(value = LogLevel.DEBUG)
    public List <MeterReadChart> populateMeterReadChart(String customerId) {

        Calendar cal = Calendar.getInstance();
        String dateTo = DateUtils.formatDate(cal.getTime());
        **cal.add(Calendar.YEAR, Constant.READ_DASHBOARD_START_DATE);**
        // getting Date from Class1
        String dateFrom = DateUtils.formatDate(class1.getUtilityDate());

            return meterReadingDao.populateMeterReadingDetail(customerId, dateFrom, dateTo);

        }
    }