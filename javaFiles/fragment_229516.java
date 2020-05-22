public static JobParametersBuilder getAttributesAsJobParameters(Object objectToConvert) throws IllegalAccessException {
    JobParametersBuilder jobParametersBuilder = new JobParametersBuilder().addLong("time", System.currentTimeMillis());

    for (Field field : objectToConvert.getClass().getDeclaredFields()) {
        field.setAccessible(true); // We need this to access to attributes if they are private
        if (!field.getType().isPrimitive()) {
            jobParametersBuilder = getAttributesAsJobParameters(field.get(objectToConvert));
        } else {
            matchJobParametersType(jobParametersBuilder, field, objectToConvert);
        }
    }
    return jobParametersBuilder;
}

public static void matchJobParametersType(JobParametersBuilder jobParametersBuilder, Field fieldOfObject, Object object) throws IllegalAccessException {
    String dataTypeOfField = fieldOfObject.getType().getSimpleName();

    switch (dataTypeOfField) {
        case "long":
            jobParametersBuilder.addLong(fieldOfObject.getName(), (Long) fieldOfObject.get(object));
            break;
        case "String":
            jobParametersBuilder.addString(fieldOfObject.getName(), (String) fieldOfObject.get(object));
            break;
        default:
            throw new JobParametersException("Data type " + dataTypeOfField + " not defined");
    }

}