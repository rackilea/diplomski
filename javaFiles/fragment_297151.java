public class JobEntitySpecifications {
    public static Specification<JobEntity> withProject(Project project) {
        if (project == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.equal(root.get("project"), project);
        }
    }

    public static Specification<JobEntity> withJobType() { ... }
    public static Specification<JobEntity> withJobStatus() { ... }
    public static Specification<JobEntity> withCreateTime() { ... }
}