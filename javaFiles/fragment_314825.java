public void putActivity(String _activityName, Activity _activity){
        if(activityMap.get(key) != null){
                activityMap.get(key).finish();
            }
        activityMap.put(_activityName, _activity);
    }