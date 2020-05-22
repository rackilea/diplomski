MessageConsumer c = session.createConsumer(destination);
 while ( b-category-can-be-processed ) {
     Message m = c.receive();
     // process messages until b category is OK to be processed
 }

 c.close();

 // now create a different consumer with message selector ignoring "B_CATEGORY"
 MessageConsumer c1 = session.createConsumer(destination, "Category <> 'B_CATEGORY'");
 while ( b-is-locked ) {
     Message m = c1.receive();
     // process messages until b category is locked
 }

 c1.close();
 // go to start