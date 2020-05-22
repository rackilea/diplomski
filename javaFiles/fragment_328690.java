this.project.name = projectDataFromForm.projectName;
this.project.description = projectDataFromForm.projectDescription;
this.project.expiryDate = projectDataFromForm.expiryDate;
this.project.budget = projectDataFromForm.budget;
// this.project.projectTypeId = this.idprojecttype;
this.project.projectTypeId = this.prMultiselectComponent.getSelectedItems();
this.project.skills = this.skillMultiselectComponent.getSelectedItems();

// --- Patch value will set values in your form ---
this.updateProjectForm.patchValue(this.project); // <---- HERE