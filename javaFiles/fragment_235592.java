public int getPoints() {
      try {
         ParseQuery<RoyalPoints> pointsQuery = RoyalPoints.getQuery();
         pointsQuery.whereEqualTo("user", ParseUser.getCurrentUser());
         List<RoyalPoints> list = pointsQuery.find();
         for (RoyalPoints obj : list) {
            totalPoints = totalPoints + obj.getInt("points");
         }

         return totalPoints;
     } catch (ParseException e) {
         Log.d("Points retrieval", "Error: " + e.getMessage());
     }
  }