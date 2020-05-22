Set<String> keySet = jsonObject.keySet();
                Iterator keySetIterator = keySet.iterator();
                while(keySetIterator.hasNext()){
                    JSONArray array = (JSONArray)jsonObject.get(keySetIterator.next());

                        while(employeeKeySetIterator.hasNext()){
                            String employeeKey = employeeKeySetIterator.next().toString();
                            System.out.println(employeeKey + " : "+ employee.get(employeeKey));
                        }
                    }
                }