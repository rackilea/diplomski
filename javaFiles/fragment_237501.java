List<Integer> planIds = Lists.newArrayList();   

    for(StorePlan plan : storePlanDao.getPlans()){
        planIds.add(plan.getId());
    }

    for (File file : getPDFs()) {
        Integer planFileId = Integer.valueOf(file.getName().substring(0, 4))
        if(!ids.contains(planFileId)) {
            file.delete();
            count++;
        }
    }