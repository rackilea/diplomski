Intrest insertObj = new Insert();
//initilize insert obj here ..

Update args = new Update();
args.addToSet("intrest",insertObj);

Query query = new Query(Criteria.where("id").is("527242d584ae917d8bd75c7b"));

// if u want to do upsert 
mongoOperation.findAndModify(query, args, FindAndModifyOptions.options().upsert(true), Post.class);

//if u want to just update
mongoOperation.findAndModify(query, args, Post.class);