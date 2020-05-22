@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HoursLocRecord_to_MasterHoursDtoMapper extends StandardMapper<HoursLocRecord, MasterHoursDto> {
        @Mapping(source = "totalOperatingHours.value", target = "totalHours")
        @Mapping(source = "trigger.value", target = "trigger")
        MasterHoursDto map(HoursLocRecord data);

        @InheritConfiguration // tell MapStruct to apply the same mappings as the method above with the same source / target
        MasterHoursDto update(HoursLocRecord from, @MappingTarget MasterHoursDto to);