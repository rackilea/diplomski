public class Feature
{
    private final String id;

    private final String description;

    private final String value;

    public Feature(final String id, final String description, final String value)
    {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Feature other = (Feature) obj;
        if (id == null)
        {
            if (other.id != null)
            {
                return false;
            }
        }
        else if (!id.equals(other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Attribute [description=" + description + ", id=" + id + ", value=" + value + "]";
    }

    }

    public class PlanComaprisionReportBuilder
    {

    Multimap<String, String> build(final Plan... plans)
    {
        Multimap<String, String> rows = ArrayListMultimap.create(100, plans.length);

        for (Plan p : plans)
        {
            for (Feature f : p.getFeatures())
            {
                rows.put(f.getDescription(), f.getValue() != null ? f.getValue() : "");
                // if (!rows.containsKey(f.getDescription()))
                // {

                // }
                // else
                // {
                // existing row needs separate handling
                // }
            }
        }
        return rows;
    }
   }