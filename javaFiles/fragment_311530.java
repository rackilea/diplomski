try {
    deleteuserDetails.setCreatedBy(result.getPropertyAsString(0).toString());
}
catch(Exception e) {
    deleteuserDetails.setCreatedBy("null");
}