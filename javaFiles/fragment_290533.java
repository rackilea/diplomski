Map<String, Map<String, List<String>>> cars; //fill data
IModel<List<? extends String>> makeChoices = new AbstractReadOnlyModel<List<? extends String>>() {
        @Override
        public List<String> getObject() {
            Set<String> keys = cars.keySet();
            List<String> list = new ArrayList<String>(keys);
            return list;
        }
    };

IModel<List<? extends String>> modelChoices = new AbstractReadOnlyModel<List<? extends String>>() {
        @Override
        public List<String> getObject() {
            Map<String, List<String>> models = cars.get(selectedMake);
            if (models == null) {
                return Collections.emptyList();
            } else {
                List<String> list = new ArrayList<String>(models.keySet());
                return list;
            }
        }
    };

 IModel<List<? extends String>> yearChoices = new AbstractReadOnlyModel<List<? extends String>>() {
        @Override
        public List<String> getObject() {
            Map<String, List<String>> models = cars.get(selectedMake);
            if (models == null) {
                return Collections.emptyList();
            } else {
                return models.get(selectedModel);
            }
        }
    };