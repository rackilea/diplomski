package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"disclaimer",
"license",
"timestamp",
"base",
"rates"
})
public class Example {

@JsonProperty("disclaimer")
private String disclaimer;
@JsonProperty("license")
private String license;
@JsonProperty("timestamp")
private Integer timestamp;
@JsonProperty("base")
private String base;
@JsonProperty("rates")
private Rates rates;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Example() {
}

/**
*
* @param timestamp
* @param disclaimer
* @param base
* @param rates
* @param license
*/
public Example(String disclaimer, String license, Integer timestamp, String base, Rates rates) {
this.disclaimer = disclaimer;
this.license = license;
this.timestamp = timestamp;
this.base = base;
this.rates = rates;
}

/**
*
* @return
* The disclaimer
*/
@JsonProperty("disclaimer")
public String getDisclaimer() {
return disclaimer;
}

/**
*
* @param disclaimer
* The disclaimer
*/
@JsonProperty("disclaimer")
public void setDisclaimer(String disclaimer) {
this.disclaimer = disclaimer;
}

/**
*
* @return
* The license
*/
@JsonProperty("license")
public String getLicense() {
return license;
}

/**
*
* @param license
* The license
*/
@JsonProperty("license")
public void setLicense(String license) {
this.license = license;
}

/**
*
* @return
* The timestamp
*/
@JsonProperty("timestamp")
public Integer getTimestamp() {
return timestamp;
}

/**
*
* @param timestamp
* The timestamp
*/
@JsonProperty("timestamp")
public void setTimestamp(Integer timestamp) {
this.timestamp = timestamp;
}

/**
*
* @return
* The base
*/
@JsonProperty("base")
public String getBase() {
return base;
}

/**
*
* @param base
* The base
*/
@JsonProperty("base")
public void setBase(String base) {
this.base = base;
}

/**
*
* @return
* The rates
*/
@JsonProperty("rates")
public Rates getRates() {
return rates;
}

/**
*
* @param rates
* The rates
*/
@JsonProperty("rates")
public void setRates(Rates rates) {
this.rates = rates;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
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


package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"one",
"two",
"three",
"four"
})
public class Rates {

@JsonProperty("one")
private Double one;
@JsonProperty("two")
private Double two;
@JsonProperty("three")
private Double three;
@JsonProperty("four")
private Double four;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Rates() {
}

/**
*
* @param two
* @param one
* @param three
* @param four
*/
public Rates(Double one, Double two, Double three, Double four) {
this.one = one;
this.two = two;
this.three = three;
this.four = four;
}

/**
*
* @return
* The one
*/
@JsonProperty("one")
public Double getOne() {
return one;
}

/**
*
* @param one
* The one
*/
@JsonProperty("one")
public void setOne(Double one) {
this.one = one;
}

/**
*
* @return
* The two
*/
@JsonProperty("two")
public Double getTwo() {
return two;
}

/**
*
* @param two
* The two
*/
@JsonProperty("two")
public void setTwo(Double two) {
this.two = two;
}

/**
*
* @return
* The three
*/
@JsonProperty("three")
public Double getThree() {
return three;
}

/**
*
* @param three
* The three
*/
@JsonProperty("three")
public void setThree(Double three) {
this.three = three;
}

/**
*
* @return
* The four
*/
@JsonProperty("four")
public Double getFour() {
return four;
}

/**
*
* @param four
* The four
*/
@JsonProperty("four")
public void setFour(Double four) {
this.four = four;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
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