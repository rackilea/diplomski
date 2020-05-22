TreeItem<ProjectEmployeeItem> root = new TreeItem<>(new ProjectEmployeeItem());
for (Project project : projectData) {
    TreeItem<ProjectEmployeeItem> projectTreeItem = new TreeItem<>(new ProjectEmployeeItem(project));
    for (Employee employee : project.getEmployees()) {
        TreeItem<ProjectEmployeeItem> employeeTreeItem = new TreeItem<>(new ProjectEmployeeItem(employee));
        projectTreeItem.getChildren().add(employeeTreeItem);
    }
    root.getChildren().add(projectTreeItem);
}