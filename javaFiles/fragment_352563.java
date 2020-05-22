List<Branch> convert(List<Map<String,String>> content) {
    return content.stream().map(this::convert).collect(Collectors.toList());
}
Branch convert(Map<String,String> props) {
    Branch branch = new Branch();
    for(String key : props.keySet()) {
        String value = props.get(key);
        switch(key) {
             case "Description": {
                  branch.setDescription(value);
                  break;
             }
             case "name": //example with multiple headers mapping to same field
             case "Label": {
                  branch.setLabel(value);
                  break;
             }
        }

    }
    return branch;
}