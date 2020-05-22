CCDictionary * cdictionary =  new CCDictionary();

  CCString *str1 = new CCString(nativeStringUserName);
  CCString *str2 = new CCString(nativeStringUserId);

  cdictionary->setObject(str1, "name");
  cdictionary->setObject(str2, "id");

  if(facebookFriendsListscreen->friendsList != NULL && facebookFriendsListscreen->friendsInstaledList != NULL) {
      facebookFriendsListscreen->friendsList->addObject(cdictionary);
      facebookFriendsListscreen->friendsInstaledList->addObject(cdictionary);
  } else {
      CCLog(" --- CCArrays are null in addInstalledFriends --- ");
  }