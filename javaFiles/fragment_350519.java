protected static void traverseParam(Map<String, List<String>> paramLists, int level, Map<String, String> paramMap) {
                if (level == paramLists.size()) {
                   //contains of all combinations
                    System.out.println(StringUtils.join(paramMap.values(), ", "));
                } else {
                    String paramKey = (String) paramLists.keySet().toArray()[level];
                    List<String> paramValues = (List<String>) paramLists.values().toArray()[level];
                    for (String paramValue : paramValues) {
                        paramMap.put(paramKey, paramValue);
                        //Recursively calls until all params are processed
                        traverseParam(paramLists, level + 1, paramMap);
                    }
                }
            }