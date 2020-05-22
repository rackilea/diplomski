@Entity
@Table(name="act_re_deployment")
public class ActivitiProcessDeployment implements Serializable{

    @OneToOne (cascade=CascadeType.ALL, mappedBy="deployment")
    private ActivitiProcessDefinition activitiProcessDefinition;
}

@Entity
@Table(name="act_re_procdef")
public class ActivitiProcessDefinition implements Serializable {

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="deployment_id_", unique= true)
    private ActivitiProcessDeployment deployment;

    //remove this
    //@JsonProperty
    //@Column(name="deployment_id_")
    //private String deploymentId;

    @JsonProperty
    public int getDeploymentId(){
        return deployment.getId();
    }
}