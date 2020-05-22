class PriorityVertex implements Comparable<PriorityVertex>
{
    private float priority;

    // Setters, getters ... whatever the vertex needs
    ...

    // Implementation of the Comparable interface:
    @Override 
    public int compareTo(PriorityVertex other)
    {
        return Float.compare(this.priority, other.priority);
    }
}