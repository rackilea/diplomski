Hashmap<Integer,Integer> map = new Hashmap<>();
ArrayList<dataset> main_list ; // it contains all objects of dataset

for(int i = 0; i < main_list.size(); i++) {
    int id = main_list.get(i).getId(); // id of the model
    map.put(id, i); // i is the position of adapter
}