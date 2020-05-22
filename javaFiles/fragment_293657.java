public String getChildrenString(Concept concept, Set<Concept> children ){
    ArrayList<String> returnedStrings = new ArrayList<>();

    for (Concept node : children){
        String nodeString = getPath(node, hierarchy.getChildrens(node), entity, hierarchy);
        returnedStrings.add(nodeString);
    }


    StringBuilder fullList = new StringBuilder();
    for (String s: returnedStrings){
        fullList.append(s+"");
    }
    return "{'id':" + concept.getId() + ","
            + "'title':'" + concept.getDescription() + "'," +
            "'nodes':[" + fullList.toString() + "]}";
}