@Entity
@Table(name = "mean")
public class Mean implements Serializable {

    private static final long serialVersionUID = -5732898358425089380L;


    // composite key
    @EmbeddedId
    private MeanPK pk = new MeanPK();

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "belief_id", insertable = false, nullable = false, updatable = false)
    private Belief belief;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "variable_id", insertable = false, nullable = false, updatable = false)
    private Variable variable;

    // more attributes excluded

    public MeanPK getPk() {
        return pk;
    }

    protected void setPk(MeanPK pk) {
        this.pk = pk;
    }


    public Belief getBelief() {
        return belief;
    }

    public void setBelief(Belief belief) {
        pk.setBelief(this.belief = belief);
    }


    @XmlTransient
    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        pk.setVariable(this.variable = variable);
    }


    @Embeddable
    public static class MeanPK implements Serializable {

        private static final long serialVersionUID = 341373316515655834L;

        @Access(AccessType.PROPERTY)
        @Column(name = "belief_id", nullable = false, updatable = false)
        protected Integer beliefId;

        @Access(AccessType.PROPERTY)
        @Column(name = "variable_id", nullable = false, updatable = false)
        protected Integer variableId;

        @Transient
        private Belief belief;

        @Transient
        private Variable variable;


        public Integer getBeliefId() {
            if (beliefId == null && belief != null) {
                beliefId = belief.getId();
            }
            return beliefId;
        }

        protected void setBeliefId(Integer beliefId) {
            this.beliefId = beliefId;
        }

        public Belief getBelief() {
            return belief;
        }

        void setBelief(Belief belief) {
            this.belief = belief;
            if (belief != null) {
                beliefId = belief.getId();
            }
        }


        public Integer getVariableId() {
            if (variableId == null && variable != null) {
                variableId = variable.getId();
            }
            return variableId;
        }

        protected void setVariableId(Integer variableId) {
            this.variableId = variableId;
        }

        public Variable getVariable() {
            return variable;
        }

        void setVariable(Variable variable) {
            this.variable = variable;
            if (variable != null) {
                variableId = variable.getId();
            }
        }


        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MeanPK)) {
                return false;
            }
            MeanPK other = (MeanPK) obj;
            return getBeliefId().equals(other.getBeliefId()) && getVariableId().equals(other.getVariableId());
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getBeliefId()).append(getVariableId()).toHashCode();
        }

    }

}