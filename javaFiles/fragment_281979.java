public class DebateTeamIterator implements Iterator<DebateTeam> {
    private Iterator<DebateAssignment> iAssignment;
    private Iterator<DebateTeam> iTeam;

    public DebateTeamIterator(Iterator<DebateTeam> iAssignment) {
        this.iAssignment = iAssignment;
        if (iAssignment.hasNext())
            iTeam = iAssignment.next().getDebateTeams().iterator();
        else
            iTeam = new LinkedList<DebateTeam>().iterator();
    }

    public boolean hasNext() {
       return iTeam.hasNext() || iAssignment.hasNext();
    }

    public DebateTeam next() {
        if (!iTeam.hasNext())
            iTeam = iAssignment.next().getDebateTeams().iterator();
        return iTeam.next();
    }

    // ... other methods removed for brevity...
}