ResultSet resultSet; // filled somewhere else
 List<Food> food = new ArrayList<Food>();

 while (resultSet.next()) {
     int id = resultSet.getInt(0); // assuming the ids are in the first column
     String name = resultSet.getString(1); // assuming the names are in the second column
     float score = resultSet.getFloat(2); // assuming the scores are in the third column

     food.add(new Food(id, name, score));
 }

 Collections.sort(food);