List<DatabaseModel> models = new ArrayList<DatabaseModel>();
for(Map.Entry<String, List<Object>> entry : individualAlarmsReturnedFromDatabase.entrySet()){
                        List<Object> value = entry.getValue();
                        for(Object valueObj : value)
                            models.add((DatabaseModel)valueObj);
                    }