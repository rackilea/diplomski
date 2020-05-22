@ManagedBean
@RequestScoped
public class TimeFormBean{

    //Initializes time with current time when bean is constructed
    private Date time = new Date();

    public Date getTime(){
        //No logic here, just return the field
        return time;
    }

    public void setTime(Date d){
        time=d;
    }

    public void processTime(){
        System.out.println("Time processed: " + time);
    }

}