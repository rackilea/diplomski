List<HashMap<String, Object>> compareData = new ArrayList<>();
    Collections.sort(compareData, new Comparator<HashMap<String, Object>>() {
        @SuppressWarnings("unchecked")
        @Override
        public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
            ArrayList<?> firstArray = (ArrayList<?>) o1.get(PRE_RELEASE);
            ArrayList<?> secondArray = (ArrayList<?>) o2.get(PRE_RELEASE);

            Object firstRun1 = null;
            for (Object firstRun : firstArray) {
                if (((HashMap<String,Object>) firstRun).get("run").equals("1")) {
                    firstRun1 = firstRun;
                    break;
                }
            }

            Object secondRun1 = null;
            for (Object secondRun : secondArray) {
                if (((HashMap<String,Object>) secondRun).get("run").equals("1")) {
                    secondRun1 = secondRun;
                    break;
                }
            }

            if (firstRun1 == secondRun1) {
                return 0;
            }
            else if (firstRun1 == null) {
                return -1;
            }
            else if (secondRun1 == null) {
                return 1;
            }
            else {
                String firstStatus = (String) ((HashMap<String,Object>) firstRun1).get(JOB_STATUS);
                String secondStatus = (String) ((HashMap<String,Object>) secondRun1).get(JOB_STATUS);

                return toNum(firstStatus).compareTo(toNum(secondStatus));
            }
        }
    });