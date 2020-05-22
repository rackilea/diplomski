match /clients/{clientId} {

  //Allow read if the user exists in the user collection for this client
  allow read: if resource.data.users[request.auth.uid] == true;

}