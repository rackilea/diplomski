@Override
public void setParameters(Map<String, String[]> parameters) {
    System.out.println("parameters: " + parameters);

    if (parameters.get("someDto.intCol")[0].length() == 0) {
        parameters.put("someDto.intCol", new String[]{"0"});
    }
}