String[] nameArr = request.getParameterValues("name");
String[] ageArr = request.getParameterValues("age");
List<ChildDTO> childList = new ArrayList<ChildDTO>();
if(nameArr != null && nameArr.length > 0 && ageArr != null && ageArr.length > 0 && nameArr.length == ageArr.length) {
    for(int i = 0; i < nameArr.length; i++) {
        ChildDTO childOne = new ChildDTO();
        childOne.setName(nameArr[i]);
        childOne.setAge(Long.valueOf(ageArr[i]));
        childList.add(childOne);
    }
}