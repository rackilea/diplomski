@Entity
class MetaDataInfo
{
   @Column
   int version;
   @Column
   String type;
   @Column
   boolean isCurrent;
}

@Entity
@FilterDef(name="lastInfo")
VersionedInfo {
  @Column
  @Filter(name="lastInfo", condition="(version = (select version from MetaDataInfo where isCurrent = true and type = \"VersionedInfo\")"
  int version;
}

@Entity
Data {

  VersionedInfo info;
}