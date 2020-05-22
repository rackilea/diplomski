@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HoursLocRecord_to_MasterHoursDtoMapper  {

        //  your overriden method To map(From from);
        @Mapping(source = "totalOperatingHours.value", target = "totalHours")
        @Mapping(source = "trigger.value", target = "trigger")
        MasterHoursDto map(HoursLocRecord data);

        // no mappings defined here, so MapStruct will try to generate
        // those missing mapping based on name similarity.
        MasterHoursDto update(HoursLocRecord from, @MappingTarget MasterHoursDto to);