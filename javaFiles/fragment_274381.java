-----------------------------------com.example.Announcement.java-----------------------------------

package com.example;

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
        "Title",
        "Description",
        "AnnouncementType",
        "ActiveF",
        "TileName"
})
public class Announcement {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("AnnouncementType")
    private String announcementType;
    @JsonProperty("ActiveF")
    private Object activeF;
    @JsonProperty("TileName")
    private Object tileName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("AnnouncementType")
    public String getAnnouncementType() {
        return announcementType;
    }

    @JsonProperty("AnnouncementType")
    public void setAnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }

    @JsonProperty("ActiveF")
    public Object getActiveF() {
        return activeF;
    }

    @JsonProperty("ActiveF")
    public void setActiveF(Object activeF) {
        this.activeF = activeF;
    }

    @JsonProperty("TileName")
    public Object getTileName() {
        return tileName;
    }

    @JsonProperty("TileName")
    public void setTileName(Object tileName) {
        this.tileName = tileName;
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
-----------------------------------com.example.SPOAnnouncement.java-----------------------------------

package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TileLevel",
        "SystemLevel",
        "Announcements"
})
public class SPOAnnouncement {

    @JsonProperty("TileLevel")
    private List<Object> tileLevel = null;
    @JsonProperty("SystemLevel")
    private List<SystemLevel> systemLevel = null;
    @JsonProperty("Announcements")
    private List<Announcement> announcements = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TileLevel")
    public List<Object> getTileLevel() {
        return tileLevel;
    }

    @JsonProperty("TileLevel")
    public void setTileLevel(List<Object> tileLevel) {
        this.tileLevel = tileLevel;
    }

    @JsonProperty("SystemLevel")
    public List<SystemLevel> getSystemLevel() {
        return systemLevel;
    }

    @JsonProperty("SystemLevel")
    public void setSystemLevel(List<SystemLevel> systemLevel) {
        this.systemLevel = systemLevel;
    }

    @JsonProperty("Announcements")
    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    @JsonProperty("Announcements")
    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
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
-----------------------------------com.example.SystemLevel.java-----------------------------------

package com.example;

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
        "Title",
        "Description",
        "AnnouncementType",
        "ActiveF",
        "TileName"
})
public class SystemLevel {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("AnnouncementType")
    private String announcementType;
    @JsonProperty("ActiveF")
    private Object activeF;
    @JsonProperty("TileName")
    private Object tileName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("AnnouncementType")
    public String getAnnouncementType() {
        return announcementType;
    }

    @JsonProperty("AnnouncementType")
    public void setAnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }

    @JsonProperty("ActiveF")
    public Object getActiveF() {
        return activeF;
    }

    @JsonProperty("ActiveF")
    public void setActiveF(Object activeF) {
        this.activeF = activeF;
    }

    @JsonProperty("TileName")
    public Object getTileName() {
        return tileName;
    }

    @JsonProperty("TileName")
    public void setTileName(Object tileName) {
        this.tileName = tileName;
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