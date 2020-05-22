package c8y.tinkerforge.measurements;

import java.math.BigDecimal;

import org.svenson.AbstractDynamicProperties;
import org.svenson.JSONProperty;

import com.cumulocity.model.measurement.MeasurementValue;
import com.cumulocity.model.util.Alias;

@Alias("c8y_Acceleration")
public class AccelerationCombinedMeasurement extends AbstractDynamicProperties {

    private static final long serialVersionUID = -2491579656609755745L;

    public static final String DEFAULT_UNIT = "g";

    private final String unit;

    private MeasurementValue accelerationX;

    private MeasurementValue accelerationY;

    private MeasurementValue accelerationZ;

    public AccelerationCombinedMeasurement(double accelerationX, double accelerationY, double accelerationZ,
            final String unit) {
        this.unit = unit;
        this.accelerationX = new MeasurementValue(new BigDecimal(accelerationX), unit);
        this.accelerationY = new MeasurementValue(new BigDecimal(accelerationY), unit);
        this.accelerationZ = new MeasurementValue(new BigDecimal(accelerationZ), unit);
    }

    @JSONProperty("accelerationX")
    public MeasurementValue getAccelerationX() {
        return accelerationX;
    }

    public void setAccelerationX(double accelerationX) {
        this.accelerationX = new MeasurementValue(new BigDecimal(accelerationX), unit);
    }

    @JSONProperty("accelerationY")
    public MeasurementValue getAccelerationY() {
        return accelerationY;
    }

    public void setAccelerationY(double accelerationY) {
        this.accelerationY = new MeasurementValue(new BigDecimal(accelerationY), unit);
    }

    @JSONProperty("accelerationZ")
    public MeasurementValue getAccelerationZ() {
        return accelerationZ;
    }

    public void setAccelerationZ(double accelerationZ) {
        this.accelerationZ = new MeasurementValue(new BigDecimal(accelerationZ), unit);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accelerationX == null) ? 0 : accelerationX.hashCode());
        result = prime * result + ((accelerationY == null) ? 0 : accelerationY.hashCode());
        result = prime * result + ((accelerationZ == null) ? 0 : accelerationZ.hashCode());
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
        AccelerationCombinedMeasurement other = (AccelerationCombinedMeasurement) obj;
        if (accelerationX == null) {
            if (other.accelerationX != null)
                return false;
        } else if (!accelerationX.equals(other.accelerationX))
            return false;
        if (accelerationY == null) {
            if (other.accelerationY != null)
                return false;
        } else if (!accelerationY.equals(other.accelerationY))
            return false;
        if (accelerationZ == null) {
            if (other.accelerationZ != null)
                return false;
        } else if (!accelerationZ.equals(other.accelerationZ))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccelerationCombinedMeasurement [accelerationX=" + accelerationX + ", accelerationY=" + accelerationY
                + ", accelerationZ=" + accelerationZ + "]";
    }

}