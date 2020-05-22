jobGroupNames is a list of String, That's why you should iterate like below.

// loop jobs by group

List<String> jobGroupNames = scheduler.getJobGroupNames();

for (String groupName : jobGroupNames ) {

// And to get Job keys :

    for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
    }
}