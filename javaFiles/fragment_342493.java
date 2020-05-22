import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ggl.project.planner.model.Planner;
import com.ggl.project.planner.model.Project;
import com.ggl.project.planner.view.CreateUpdateProjectDialog;
import com.ggl.project.planner.view.ProjectPlannerFrame;

public class CreateProjectActionListener implements ActionListener {

    protected Planner planner;

    protected Project project;

    protected ProjectPlannerFrame frame;

    public CreateProjectActionListener(ProjectPlannerFrame frame,
            Planner planner, Project project) {
        this.frame = frame;
        this.planner = planner;
        this.project = project;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        CreateUpdateProjectDialog dialog = 
                new CreateUpdateProjectDialog(frame, project, true);
        if (dialog.isOkPressed()) {
            planner.setProjectOpen(true);
        }
    }

}