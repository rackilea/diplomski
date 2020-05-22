public List<Car> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {  
        List<Car> data = new ArrayList<Car>();  

        //filter  
        for(Car car : datasource) {  
            boolean match = true;  

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    String filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));  

...