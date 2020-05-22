@Entity
public class SuiteVersion {
    ...
    @ManyToMany
    private List<ModuleVersion> moduleVersions = new ArrayList<ModuleVersion>();

    ...

    public void removeFromModuleVersions(ModuleVersion module) {
        this.moduleVersions.remove(module);
        module.getSuiteVersions().remove(this);
    }

    public void addToModuleVersions(ModuleVersion module) {
        this.moduleVersions.add(module);
        module.getSuiteVersions().add(this);
    }

}