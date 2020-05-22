@ManyToOne
@JoinColumn(
    name = "workflow_instance_id", 
    referencedColumnName = "workflow_instance_id",
    insertable = false, 
    updatable = false
)
private WorkflowInstance workflowInstance;

@ManyToOne
@JoinColumnOrFormula(
    formula = @JoinFormula(
            value="(SELECT a.work_action_class_id FROM WorkActionClass a WHERE a.role_class_id = role_class_id)", 
        referencedColumnName = "work_action_class_id"
    )
)
private WorkActionClass workActionClass;

@ManyToOne
@JoinColumns( {
    @JoinColumn(
        name = "workflow_instance_id", 
        referencedColumnName = "workflow_instance_id"),
    @JoinColumn(
        name = "role_class_id", 
        referencedColumnName = "role_class_id")
})
private WorkflowInstancePlayer player;