import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Frequency",
"Range"
})
public class Result1 {

@JsonProperty("Frequency")
private Double frequency;
@JsonProperty("Range")
private Double range;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("Frequency")
public Double getFrequency() {
return frequency;
}

@JsonProperty("Frequency")
public void setFrequency(Double frequency) {
this.frequency = frequency;
}

@JsonProperty("Range")
public Double getRange() {
return range;
}

@JsonProperty("Range")
public void setRange(Double range) {
this.range = range;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}