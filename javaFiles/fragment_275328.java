@Basic(optional=false)
@Column(name="moment" columnDefinition="DATETIME(3) NOT NULL")
@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
public DateTime getMoment() 
{   
   ...