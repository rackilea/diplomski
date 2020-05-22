int j = 0;
for (int i = 0; i < xmlTests.size(); i++) {

            if (j>= params.size()) {
               j = 0;
            }

            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("param", params.get(j));
            xmlTests.get(i).setParameters(paramsMap);
            j++;
        }