...
Predicate predicate = cb.disjunction();
if (usersList != null) {
    ListJoin<ScheduleRequest, Application> applications = scheduleRequest.join(ScheduleRequest_.applications);
    ListJoin<Application, UserApplication> userApplications = applications.join(Application_.userApplications);
    Join<UserApplication, User> user = userApplications.join(UserApplication_.userId);
    for (String userName : usersList) {
        predicate = builder.or(predicate, builder.equal(user.get(User_.name), userName));
    }
}

criteria.where(predicate); 
...