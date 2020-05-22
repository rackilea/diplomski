<div class="container custom-container">
    <form [formGroup]="updateProjectForm" (ngSubmit)="updateProject(updateProjectForm.value)" class="ui form"
        style="margin-left: 3%; width: 30%;">
        <h1 id="projectTitle">Update Project</h1>

        <div style="margin: 0 auto;" *ngIf='projectData'>     <!-- HERE -->
            <div style="margin-top: 100px;">
                <div class="field">
                    <label>Project Name</label>
                    <input type="text" formControlName="projectName" class="form-control" name="projectName"
                        [(ngModel)]="projectData.name" placeholder="Your project name"
                        [ngClass]="{'is-invalid' : submitted && updateProjectForm.controls.projectName.errors}" />
                    <div *ngIf="submitted && updateProjectForm.controls.projectName.errors" class="err_msg form-text">
                        <p class="err-msg">Project Name is required</p>
                    </div>

                </div>
                ...
            </div>
        </div>
    </form>
</div>