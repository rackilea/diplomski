public class Course {

    int moduleId;
    String moduleCode;
    String module;
    List<Integer> professorIds;

    public Course() {

    }

    public Course(int moduleId, String moduleCode, String module, List<Integer> professorIds) {
        this.moduleId = moduleId;
        this.moduleCode = moduleCode;
        this.module = module;
        this.professorIds = professorIds;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Integer> getProfessorIds() {
        return professorIds;
    }

    public void setProfessorIds(List<Integer> professorIds) {
        this.professorIds = professorIds;
    }

}