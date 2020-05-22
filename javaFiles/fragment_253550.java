project.ext {
    subprojectList = subprojects.findAll{
        it.name == 'subprojectA' ||
        it.name == 'subprojectB' ||
        it.name == 'subprojectC'
    }
}
  configure(project.subprojectList) {
    // insert your custom configuration code
}