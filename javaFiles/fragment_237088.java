Builder builder=Point.measurement(measurementName).time(date,TimeUnit.MILLISECONDS).tag("source", source);

    for (Map.Entry<String, String> entry : tagMap.entrySet()) {
        builder.tag(entry.getKey(),entry.getValue());
    }

    for (Map.Entry<String, Long> entry : filedMap.entrySet()) {
        builder.addField(entry.getKey(),entry.getValue());
    }

    builder.addField("recordcount", 1);
    point=builder.build();