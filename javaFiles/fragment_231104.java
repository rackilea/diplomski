// put the statuses directly into the model
Map statusMap = new HashMap();
statusMap.put("user", User.Status.USER);
statusMap.put("groupOperator", User.Status.ADMIN);
...
modelAndView.addObject("statusmap", statusMap);