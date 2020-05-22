private static class Record implements Comparable<Record> {
    // public final fields ok for this small example
    public final String string;
    public final double value;

    public Record(String string, double value) {
        this.string = string;
        this.value = value;
    }

    @Override
    public int compareTo(Record other) {
        // define sorting according to double fields
        return Double.compare(value, other.value); 
    }
}

// provide size to avoid reallocations
List<Record> records = new ArrayList<Record>(stringList.size());
for(String s : stringList)
    records.add(new Record(s, calculateFitness(s));
Collections.sort(records); // sort according to compareTo method
int max = Math.min(10, records.size()); // maximum index
List<String> result = new ArrayList<String>(max);
for(int i = 0; i < max; i++)
    result.add(records.get(i).string);
return result;