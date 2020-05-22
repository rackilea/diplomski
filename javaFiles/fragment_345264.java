Comparator<HashMap<String, String>> comparator = new Comparator<HashMap<String, String>>() {                                    
        @Override
        public int compare(HashMap<String, String> object1, HashMap<String, String> object2) 
        {       
                return object1.get("title").compareToIgnoreCase(object2.get("title"));
        }
};      
Collections.sort(groupData, comparator);