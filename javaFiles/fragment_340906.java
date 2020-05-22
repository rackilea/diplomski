public class Jenkinjobs
    {
        private Jobs[] jobs;

        public Jobs[] getJobs ()
        {
            return jobs;
        }

        public void setJobs (Jobs[] jobs)
        {
            this.jobs = jobs;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [jobs = "+jobs+"]";
        }
    }


public class Jobs
{
    private LastBuild lastBuild;

    private String name;

    private String url;

    public LastBuild getLastBuild ()
    {
        return lastBuild;
    }

    public void setLastBuild (LastBuild lastBuild)
    {
        this.lastBuild = lastBuild;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastBuild = "+lastBuild+", name = "+name+", url = "+url+"]";
    }
}


public class LastBuild
{
    private String timestamp;

    private String estimatedDuration;

    private String duration;

    private String building;

    private String number;

    private String builtOn;

    private String url;

    private Actions[] actions;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getEstimatedDuration ()
    {
        return estimatedDuration;
    }

    public void setEstimatedDuration (String estimatedDuration)
    {
        this.estimatedDuration = estimatedDuration;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getBuilding ()
    {
        return building;
    }

    public void setBuilding (String building)
    {
        this.building = building;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getBuiltOn ()
    {
        return builtOn;
    }

    public void setBuiltOn (String builtOn)
    {
        this.builtOn = builtOn;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Actions[] getActions ()
    {
        return actions;
    }

    public void setActions (Actions[] actions)
    {
        this.actions = actions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", estimatedDuration = "+estimatedDuration+", duration = "+duration+", building = "+building+", number = "+number+", builtOn = "+builtOn+", url = "+url+", actions = "+actions+"]";
    }
}

public class Parameters
{
    private String name;

    private String value;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", value = "+value+"]";
    }
}



public class Actions
{
    private Causes[] causes;

    public Causes[] getCauses ()
    {
        return causes;
    }

    public void setCauses (Causes[] causes)
    {
        this.causes = causes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [causes = "+causes+"]";
    }
}



public class Causes
{
    private String shortDescription;

    public String getShortDescription ()
    {
        return shortDescription;
    }

    public void setShortDescription (String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [shortDescription = "+shortDescription+"]";
    }
}