import java.time.Instant;
import java.util.Objects;

public class StationReading {
    private final String name;
    private final Instant time;
    private final double frequency;
    private final double targetPower;
    private final double power;
    private final double stateOfCharge;

    public StationReading(String name,
                          Instant time,
                          double frequency,
                          double targetPower,
                          double power,
                          double stateOfCharge) {
        this.name = name;
        this.time = time;
        this.frequency = frequency;
        this.targetPower = targetPower;
        this.power = power;
        this.stateOfCharge = stateOfCharge;
    }

    public String getName() {
        return name;
    }

    public Instant getTime() {
        return time;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getTargetPower() {
        return targetPower;
    }

    public double getPower() {
        return power;
    }

    public double getStateOfCharge() {
        return stateOfCharge;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
            "[name=\"" + name + "\"" +
            ", time=" + time +
            ", frequency=" + frequency +
            ", target power=" + targetPower +
            ", power=" + power +
            ", state of charge=" + stateOfCharge +
            "]";
    }

    public static StationReading fromLine(String line) {
        Objects.requireNonNull(line, "Line cannot be null.");

        String[] fields = line.split(",");
        if (fields.length != 6) {
            throw new IllegalArgumentException(
                "Cannot parse a line unless it has exactly six fields.");
        }

        String name = fields[0];

        Instant time = Instant.parse(fields[1]);
        // When you get a new CSV which represents times in milliseconds,
        // change the above to:
        //
        // double ms = Double.parseDouble(fields[1]);
        // Instant time = Instant.ofEpochMilli((long) ms);
        // time = time.plusNanos((long) ((ms - Math.floor(ms)) * 1_000_000));

        double frequency = Double.parseDouble(fields[2]);
        double targetPower = Double.parseDouble(fields[3]);
        double power = Double.parseDouble(fields[4]);
        double stateOfChange = Double.parseDouble(fields[5]);

        return new StationReading(name, time,
            frequency, targetPower, power, stateOfChange);
    }
}