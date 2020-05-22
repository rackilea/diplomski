private final Set<Feature> features = Sets.newHashSet();

public Plan(final String id)
{
    this.id = id;
}

public String getId()
{
    return id;
}

public void addFeature(final Feature f)
{
    features.add(f);
}

public Set<Feature> getFeatures()
{
    return Collections.unmodifiableSet(features);
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
    Plan other = (Plan) obj;
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
    return "Plan [features=" + features + ", id=" + id + "]";
}