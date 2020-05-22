List<String> matchList = new ArrayList<String>( 
            Arrays.asList("name1", 
                          "name2", 
                          "name3")); 

objectiveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = objectives.get(position);
        if (matchList.contains(name) {
            // DO STUFF
        }
    }
});