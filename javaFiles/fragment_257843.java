public class Adapter {

    public List<Adapter> adaptCollection(List<Name> names) {
        List<Adapter> adapters = new ArrayList<Adapter>(names.size());

        for (Name name : names) {
            adapters.add(new Adapter(name));
        }

        return adapters;
    }


    private final int name;

    public Adapter(Name name) {
        this.name = name.getWeightedResult();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adapter other = (Adapter) obj;
        if (name != other.name)
            return false;
        return true;
    }

}