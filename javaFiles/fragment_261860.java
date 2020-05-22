List<Skills> mskills = skillsService.getAll();
List<String> matchName = new ArrayList<String>();
for(Skills skills : mskills ){
        String nameVal =  skills.getName();
        matchName.add(nameVal); //having an issue here
    }
return matchName;