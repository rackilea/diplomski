-----------------------------------com.example.Building.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Building {

@SerializedName("created")
@Expose
private String created;
@SerializedName("id")
@Expose
private int id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parentId")
@Expose
private int parentId;

/**
* No args constructor for use in serialization
* 
*/
public Building() {
}

/**
* 
* @param id
* @param parentId
* @param created
* @param name
*/
public Building(String created, int id, String name, int parentId) {
super();
this.created = created;
this.id = id;
this.name = name;
this.parentId = parentId;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public Building withCreated(String created) {
this.created = created;
return this;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Building withId(int id) {
this.id = id;
return this;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Building withName(String name) {
this.name = name;
return this;
}

public int getParentId() {
return parentId;
}

public void setParentId(int parentId) {
this.parentId = parentId;
}

public Building withParentId(int parentId) {
this.parentId = parentId;
return this;
}

}
-----------------------------------com.example.Example.java-----------------------------------

package com.example;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("territories")
@Expose
private List<Territory> territories = new ArrayList<Territory>();
@SerializedName("streets")
@Expose
private List<Street> streets = new ArrayList<Street>();
@SerializedName("buildings")
@Expose
private List<Building> buildings = new ArrayList<Building>();
@SerializedName("flats")
@Expose
private List<Flat> flats = new ArrayList<Flat>();
@SerializedName("vists")
@Expose
private List<Vist> vists = new ArrayList<Vist>();

/**
* No args constructor for use in serialization
* 
*/
public Example() {
}

/**
* 
* @param vists
* @param territories
* @param buildings
* @param streets
* @param flats
*/
public Example(List<Territory> territories, List<Street> streets, List<Building> buildings, List<Flat> flats, List<Vist> vists) {
super();
this.territories = territories;
this.streets = streets;
this.buildings = buildings;
this.flats = flats;
this.vists = vists;
}

public List<Territory> getTerritories() {
return territories;
}

public void setTerritories(List<Territory> territories) {
this.territories = territories;
}

public Example withTerritories(List<Territory> territories) {
this.territories = territories;
return this;
}

public List<Street> getStreets() {
return streets;
}

public void setStreets(List<Street> streets) {
this.streets = streets;
}

public Example withStreets(List<Street> streets) {
this.streets = streets;
return this;
}

public List<Building> getBuildings() {
return buildings;
}

public void setBuildings(List<Building> buildings) {
this.buildings = buildings;
}

public Example withBuildings(List<Building> buildings) {
this.buildings = buildings;
return this;
}

public List<Flat> getFlats() {
return flats;
}

public void setFlats(List<Flat> flats) {
this.flats = flats;
}

public Example withFlats(List<Flat> flats) {
this.flats = flats;
return this;
}

public List<Vist> getVists() {
return vists;
}

public void setVists(List<Vist> vists) {
this.vists = vists;
}

public Example withVists(List<Vist> vists) {
this.vists = vists;
return this;
}

}
-----------------------------------com.example.Flat.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flat {

@SerializedName("created")
@Expose
private String created;
@SerializedName("id")
@Expose
private int id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parentId")
@Expose
private int parentId;

/**
* No args constructor for use in serialization
* 
*/
public Flat() {
}

/**
* 
* @param id
* @param parentId
* @param created
* @param name
*/
public Flat(String created, int id, String name, int parentId) {
super();
this.created = created;
this.id = id;
this.name = name;
this.parentId = parentId;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public Flat withCreated(String created) {
this.created = created;
return this;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Flat withId(int id) {
this.id = id;
return this;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Flat withName(String name) {
this.name = name;
return this;
}

public int getParentId() {
return parentId;
}

public void setParentId(int parentId) {
this.parentId = parentId;
}

public Flat withParentId(int parentId) {
this.parentId = parentId;
return this;
}

}
-----------------------------------com.example.Street.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street {

@SerializedName("created")
@Expose
private String created;
@SerializedName("id")
@Expose
private int id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parentId")
@Expose
private int parentId;

/**
* No args constructor for use in serialization
* 
*/
public Street() {
}

/**
* 
* @param id
* @param parentId
* @param created
* @param name
*/
public Street(String created, int id, String name, int parentId) {
super();
this.created = created;
this.id = id;
this.name = name;
this.parentId = parentId;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public Street withCreated(String created) {
this.created = created;
return this;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Street withId(int id) {
this.id = id;
return this;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Street withName(String name) {
this.name = name;
return this;
}

public int getParentId() {
return parentId;
}

public void setParentId(int parentId) {
this.parentId = parentId;
}

public Street withParentId(int parentId) {
this.parentId = parentId;
return this;
}

}
-----------------------------------com.example.Territory.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Territory {

@SerializedName("created")
@Expose
private String created;
@SerializedName("id")
@Expose
private int id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parentId")
@Expose
private int parentId;

/**
* No args constructor for use in serialization
* 
*/
public Territory() {
}

/**
* 
* @param id
* @param parentId
* @param created
* @param name
*/
public Territory(String created, int id, String name, int parentId) {
super();
this.created = created;
this.id = id;
this.name = name;
this.parentId = parentId;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public Territory withCreated(String created) {
this.created = created;
return this;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Territory withId(int id) {
this.id = id;
return this;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Territory withName(String name) {
this.name = name;
return this;
}

public int getParentId() {
return parentId;
}

public void setParentId(int parentId) {
this.parentId = parentId;
}

public Territory withParentId(int parentId) {
this.parentId = parentId;
return this;
}

}
-----------------------------------com.example.Vist.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vist {

@SerializedName("buildingId")
@Expose
private int buildingId;
@SerializedName("categoryId")
@Expose
private int categoryId;
@SerializedName("dateTime")
@Expose
private String dateTime;
@SerializedName("description")
@Expose
private String description;
@SerializedName("flatId")
@Expose
private int flatId;
@SerializedName("id")
@Expose
private int id;
@SerializedName("streetId")
@Expose
private int streetId;
@SerializedName("territoryId")
@Expose
private int territoryId;

/**
* No args constructor for use in serialization
* 
*/
public Vist() {
}

/**
* 
* @param id
* @param territoryId
* @param flatId
* @param streetId
* @param dateTime
* @param description
* @param categoryId
* @param buildingId
*/
public Vist(int buildingId, int categoryId, String dateTime, String description, int flatId, int id, int streetId, int territoryId) {
super();
this.buildingId = buildingId;
this.categoryId = categoryId;
this.dateTime = dateTime;
this.description = description;
this.flatId = flatId;
this.id = id;
this.streetId = streetId;
this.territoryId = territoryId;
}

public int getBuildingId() {
return buildingId;
}

public void setBuildingId(int buildingId) {
this.buildingId = buildingId;
}

public Vist withBuildingId(int buildingId) {
this.buildingId = buildingId;
return this;
}

public int getCategoryId() {
return categoryId;
}

public void setCategoryId(int categoryId) {
this.categoryId = categoryId;
}

public Vist withCategoryId(int categoryId) {
this.categoryId = categoryId;
return this;
}

public String getDateTime() {
return dateTime;
}

public void setDateTime(String dateTime) {
this.dateTime = dateTime;
}

public Vist withDateTime(String dateTime) {
this.dateTime = dateTime;
return this;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Vist withDescription(String description) {
this.description = description;
return this;
}

public int getFlatId() {
return flatId;
}

public void setFlatId(int flatId) {
this.flatId = flatId;
}

public Vist withFlatId(int flatId) {
this.flatId = flatId;
return this;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Vist withId(int id) {
this.id = id;
return this;
}

public int getStreetId() {
return streetId;
}

public void setStreetId(int streetId) {
this.streetId = streetId;
}

public Vist withStreetId(int streetId) {
this.streetId = streetId;
return this;
}

public int getTerritoryId() {
return territoryId;
}

public void setTerritoryId(int territoryId) {
this.territoryId = territoryId;
}

public Vist withTerritoryId(int territoryId) {
this.territoryId = territoryId;
return this;
}

}