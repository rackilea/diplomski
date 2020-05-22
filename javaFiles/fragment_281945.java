public interface Agent {

@XBRead("/root/agent/id")
String getId();

@XBRead("/root/agent/name")
String getName();

@XBRead("/root/agent/forename")
String getForname();

@XBRead("/root/agent/unit/name")
String getUnitName();

@XBRead("/root/agent/unit/legacyStructurBlablabla/type")
String getUnitType();