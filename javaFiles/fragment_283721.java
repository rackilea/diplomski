if (retrieveJob(newTrigger.getJobKey()) == null) {
    throw new JobPersistenceException("The job ("
            + newTrigger.getJobKey()
            + ") referenced by the trigger does not exist.");
}

// add to triggers array
triggers.add(tw);