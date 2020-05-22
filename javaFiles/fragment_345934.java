JSONArray users = (JSONArray) JSONValue.parse(json);
JSONObject firstUser = (JSONObject) users.get(0);

JSONArray firstUserGoals = (JSONArray) firstUser.get("Goals");
JSONObject firstUserFirstGoal = (JSONObject) firstUserGoals.get(0);

JSONArray firstUserFirstGoalMilestones = (JSONArray) firstUserFirstGoal.get("milestones");
JSONObject firstUserFirstGoalFirstMilestone = (JSONObject) firstUserFirstGoalMilestones.get(0);