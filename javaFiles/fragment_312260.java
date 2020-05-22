private static final long minDateDiff = 3600000;    //1H in milliseconds

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Name")
    private String name;    //using same name for activities in same project not supported.
    @Column(name="Description")
    private String description;
    @Column(name="Start_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="End_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name="Duration")
    private long duration;
    @ManyToOne
    @JoinColumn(name="Project_Id")
    private Project parent;


    public Activity(){

    }
    /**
     * Activity constructor, automatically sets default start and end date.
     * @param newName Name of the new activity
     * @param parent id of parent project
     */
    public Activity(String newName, int parentId){
        this.parent = new Project(parentId);
        this.name = newName;
        this.startDate = new Date();    //start date by default is creation time
        this.endDate = new Date();
        this.endDate.setTime(startDate.getTime() + Activity.minDateDiff);   //end date by default is 1 hour ahead of start date
        this.description = new String();
        this.getDateDiff(startDate, endDate, TimeUnit.HOURS);   //set default duration
    }

    public void getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {    //converts difference between dates from 
                                                                                //milliseconds to given time unit
                                                                            //credit to Sebastien Lorber (from StackOverflow)
        long diffInMillies = date2.getTime() - date1.getTime();
        this.duration=timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return this.name;
    }

    public void setStartDate(Date newStartDate){
        Date dummyDate = new Date();
        if(newStartDate.getTime() > dummyDate.getTime()){   //rough check to ensure start date
                                                            //isn't in the past - precise enough
                                                            //for application's needs
             this.startDate = newStartDate; 
        }
        if(this.startDate.getTime() >= this.endDate.getTime()){ //shifts endDate 1 hour ahead of startDate if the new startDate
                                                                //is higher
            this.endDate.setTime(this.startDate.getTime() + 3600000);
        }
    }

    public void setEndDate(Date newEndDate){
        Date dummyDate = new Date();
        if(newEndDate.getTime() > dummyDate.getTime() && this.startDate.getTime() < newEndDate.getTime()){
                                                            //rough check to ensure end date
                                                            //isn't in the past or before start date - precise enough
                                                            //for application's needs
             this.endDate = newEndDate; 
        }
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    public String getDescription(){
        return this.description;
    }

    public void addManager(String newManager){
        //this.activityManagers.add(newManager);

    }

    /**
     * Returns how long the Activity will take.
     * @return Activity duration in hours.
     */
    public long getDuration(){  //returns how long the activity will take in hours.
        return this.duration;
    }

    /**
     * Saves Activity data to database
     */
    public void commitChanges(){
        MySqlDriver.saveObject(this);
    }

    public void loadData(int activityToLoadId){ //loads data of activity with name activityToLoadName from database
        this.id = activityToLoadId;
        MySqlDriver.loadObjectWithId(this, activityToLoadId);
    }
}