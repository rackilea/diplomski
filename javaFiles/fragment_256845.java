DisturbanceCourseEntity disturbanceCourseEntity = DisturbanceCourseEntity
        .builder()
        .latitude(latitude)
        .longitude(longitude)
        .orderNumber(shapeId)
        .trafficJamEntity(trafficJamEntity)
        .build();

trafficJamEntity.getDisturbanceCourseEntitySet().add(disturbanceCourseEntity);