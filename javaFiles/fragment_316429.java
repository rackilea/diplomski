Long recordId = recordWrapperDtos
         .stream()
         .filter(c -> c.getRecordWrapperId() != null)
         .map(RecordWrapperDto::getRecordId)
         .findFirst()
         .orElse(null);
return recordWrapperDtos
         .stream()
         .filter(c -> c.getRecordWrapperId() != null)
         .filter(c -> recordId.equals(c.getRecordId()))
         .collect(Collectors.toList());