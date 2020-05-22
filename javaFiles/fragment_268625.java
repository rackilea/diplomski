import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TreeGrid;
import com.vaadin.ui.VerticalLayout;

import java.util.*;
import java.util.stream.Stream;

public class BasicTreeGrid extends VerticalLayout {

    // used to generate some random data
    private final Random random = new Random();

    public BasicTreeGrid() {
        // basic setup
        setSizeFull();
        TreeGrid<Project> treeGrid = new TreeGrid<>();
        treeGrid.setSizeFull();
        addComponent(treeGrid);
        treeGrid.addColumn(Project::getName).setCaption("Project Name").setId("name-column");
        treeGrid.addColumn(Project::getHoursDone).setCaption("Hours Done").setId("hour-column");
        treeGrid.addColumn(Project::getLastModified).setCaption("Last Modified").setId("date-column");
        treeGrid.addColumn(Project::getStatus).setCaption("Status").setId("status-column");

        // some listeners for interaction
        treeGrid.addCollapseListener(event -> Notification
                .show("Project '" + event.getCollapsedItem().getName() + "' collapsed.", Notification.Type.TRAY_NOTIFICATION));
        treeGrid.addExpandListener(event -> Notification
                .show("Project '" + event.getExpandedItem().getName() + "' expanded.", Notification.Type.TRAY_NOTIFICATION));


        // add the list of root projects and specify a provider of sub-projects
        TreeData<Project> data = new TreeData<>();
        data.addItems(generateProjectsForYears(2010, 2016), Project::getSubProjects);
        TreeDataProvider<Project> dataProvider = new TreeDataProvider<>(data);
        treeGrid.setDataProvider(dataProvider);

        // filter combo setup
        ComboBox<Status> statusFilter = new ComboBox<>();
        statusFilter.setItems(Status.values());
        statusFilter.setEmptySelectionCaption("ALL");
        statusFilter.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                dataProvider.clearFilters();
            } else {
                dataProvider.setFilter(project -> {
                    if (project.getSubProjects() == null | project.getSubProjects().isEmpty()) {
                        // include final nodes matching the filter
                        return project.getStatus() == null || project.getStatus() == event.getValue();
                    } else {
                        // include root and intermediate nodes that have children matching the filter
                        return project.flatten().anyMatch(subProject -> subProject.getStatus() == event.getValue());
                    }
                });
            }
        });

        // add filter combo to header
        treeGrid.appendHeaderRow().getCell("status-column").setComponent(statusFilter);
    }

    // generate some random projects
    private List<Project> generateProjectsForYears(int startYear, int endYear) {
        List<Project> projects = new ArrayList<>();

        for (int year = startYear; year <= endYear; year++) {
            Project yearProject = new Project("Year " + year);

            for (int i = 1; i < 2 + random.nextInt(5); i++) {
                Project customerProject = new Project("Customer Project " + i);
                customerProject.setSubProjects(Arrays.asList(
                        new LeafProject("Implementation", random.nextInt(100), year, Status.values()[random.nextInt(3)]),
                        new LeafProject("Planning", random.nextInt(10), year, Status.values()[random.nextInt(3)]),
                        new LeafProject("Prototyping", random.nextInt(20), year, Status.values()[random.nextInt(3)])));
                yearProject.addSubProject(customerProject);
            }
            projects.add(yearProject);
        }
        return projects;
    }

    // project status
    enum Status {
        NOT_STARTED, IN_PROGRESS, DONE
    }

    // basic parent (or intermediate child) bean used for easy binding
    class Project {
        private List<Project> subProjects = new ArrayList<>();
        private String name;
        private Status status;

        public Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Project> getSubProjects() {
            return subProjects;
        }

        public void setSubProjects(List<Project> subProjects) {
            this.subProjects = subProjects;
        }

        public void addSubProject(Project subProject) {
            subProjects.add(subProject);
        }

        public int getHoursDone() {
            return getSubProjects().stream().map(project -> project.getHoursDone()).reduce(0, Integer::sum);
        }

        public Date getLastModified() {
            return getSubProjects().stream().map(project -> project.getLastModified()).max(Date::compareTo).orElse(null);
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        // flatten the project hierarchy into a stream of items
        public Stream<Project> flatten() {
            return Stream.concat(
                    Stream.of(this),
                    subProjects.stream().flatMap(Project::flatten));
        }
    }


    // basic final child (can not have other children) bean used for easy binding
    class LeafProject extends Project {
        private int hoursDone;
        private Date lastModified;

        public LeafProject(String name, int hoursDone, int year, Status status) {
            super(name);
            setStatus(status);
            this.hoursDone = hoursDone;
            lastModified = new Date(year - 1900, random.nextInt(12), random.nextInt(10));
        }

        @Override
        public int getHoursDone() {
            return hoursDone;
        }

        @Override
        public Date getLastModified() {
            return lastModified;
        }
    }
}