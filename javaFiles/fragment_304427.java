yComponent +=
    ((Math.min(i.getObservedIndividuals(), ii.getObservedIndividuals())) /
    (double) Math.max(i.getObservedIndividuals(), ii.getObservedIndividuals())*
    i.getObservedIndividuals()) /
    (double) (parent.getShareableSpecies()*
    match.getTotalObservedIndividuals());