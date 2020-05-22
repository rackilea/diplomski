List<person> resultSet = new ArrayList<person>();
    for(int i = 0; i<personList.size(); i++){
        if(personList.get(i).getName().contains(searchName)){
            resultSet.add((personList.get(i))
        }
    }

    for(int i = 0; i<resultSet.size(); i++){
        System.out.println((i+1) + ". " + resultSet.get(i).getName() +" "+ resultSet.get(i).getAge());
    }