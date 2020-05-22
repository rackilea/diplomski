db.users.find(
  {"linkedaccounts.virtualid": "ranik@xyz"} ,
  {
    _id: 0,     
   linkedaccounts: {$elemMatch: {virtualid:"ranik@xyz"}}
   }
);