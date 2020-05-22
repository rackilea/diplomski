enum SynapseState {
    CONNECTED(0) {
        @Override
        List<StateParameter> getStateParameters() {
            return null;
        }
    }, ACTIVE(1) {
        @Override
        List<StateParameter> getStateParameters() {
            return null;
        }
    }, PREVIOUS_ACTIVE(2) {
        @Override
        List<StateParameter> getStateParameters() {
            return null;
        }
    };

    private int value;

    private SynapseState(int value) {
        this.value = value;
    }
    abstract List<StateParameter> getStateParameters();

};

class SynapseMachine{

    List<Synapse> connectedSynapses;
    List<Synapse> activeSynapses;
    List<Synapse> previousActiveSynapses;
    List<Synapse> synapses;



    public void addSynapse(Synapse synapse)
    {
        Synapse newSynapse = new Synapse(synapse.getInputCell());
        this.synapses.add(newSynapse);

        switch(synapse.getState()){
        case CONNECTED:
             this.connectedSynapses.add(newSynapse);
            break;
        case ACTIVE:
            this.activeSynapses.add(newSynapse);
            break;
        case PREVIOUS_ACTIVE:
            this.previousActiveSynapses.add(newSynapse);

            break;
         default:   
             throw new IllegalStateException();
        }
    }   
}

class Synapse{
    public Synapse(Object o){}

    SynapseState getState(){
        // TODO Auto-generated method stub
        return null;    
    }

    public Object getInputCell() {
        // TODO Auto-generated method stub
        return null;
    }
}

class StateParameter{

}