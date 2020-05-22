@Override
public String getStatus(Project project) {
    /* Create Final Strings */
    final String TODO = "TODO";
    final String INP = "In Progress";
    final String DONE = "Done";

    /* Boolean Flag */
    boolean flag = false;

    /* Comparison Logic */
    Iterator<Requirement> it = project.listRequirement.iterator();
    while (it.hasNext()) {
        Requirement s = it.next();

        if (TODO.equalsIgnoreCase(s.getStatus())) {
            return TODO;
        } else if (INP.equalsIgnoreCase(s.getStatus())) {
            flag = true;
        }
    }

    /* Return Done */
    if(flag) return INP;
    else return DONE;
}