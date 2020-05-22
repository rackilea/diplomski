@(users: List[User])

@for(user <- users){
   <p>user.id</p>
   <p>user.name</p>
   etc...
}