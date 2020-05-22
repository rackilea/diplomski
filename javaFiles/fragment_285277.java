categoryID = getIntent().getStringExtra("CategoryID");
foodId = getIntent().getStringExtra("FoodId");

database = FirebaseDataBase.getInstance();

foods = database.getReference("Food/" + categoryID + "/" + foodId);