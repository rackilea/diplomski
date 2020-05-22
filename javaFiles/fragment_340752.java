public class DataTable {

    private List<Entry> table = new ArrayList<Entry>();

    public double getValue(Sex sex, MaritalStatus maritalStatus, AgeInterval ageInterval, Type type) {
        for (Entry entry : table) {
            if (entry.sex == sex && entry.maritalStatus == maritalStatus && entry.ageInterval == ageInterval && entry.type == type) {
                return entry.value;
            }
        }
        throw new IllegalArgumentException("Unknown value");
    }

    public void load(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, ":");
                table.add(new Entry(
                        Sex.valueOf(t.nextToken()),
                        MaritalStatus.valueOf(t.nextToken()),
                        AgeInterval.valueOf(t.nextToken()),
                        Type.valueOf(t.nextToken()),
                        Double.valueOf(t.nextToken())));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read the data file", e);
        }
    }

}

enum Sex {M, F}
enum MaritalStatus {SINGLE, MARRIED}
enum AgeInterval {I16_21, I22_35, I35_55, I55}
enum Type {GD, NGD} // Whatever this is ...

class Entry {
    Sex sex;
    MaritalStatus maritalStatus;
    AgeInterval ageInterval;
    Type type;
    double value;

    Entry(Sex sex, MaritalStatus maritalStatus, AgeInterval ageInterval, Type type, double value) {
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.ageInterval = ageInterval;
        this.type = type;
        this.value = value;
    }
}