// use this method call inside the database records reading method
addModule(rs.getInt("moduleId"), rs.getString("moduleCode"), rs.getString("module"), professorIdsIntList));

public void addModule(int moduleId, String moduleCode, String module, List<Integer> professorIds) { 
    this.modules.put(moduleId, new Module(moduleId, moduleCode, module, professorIds)); 
}