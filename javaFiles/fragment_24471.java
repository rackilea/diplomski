"Users": {
  "$uid": {
    ".write": "auth !== null && auth.uid === $uid",
    ".read": "auth !== null && auth.provider === 'password'",
    "userName": {
      ".validate": "
        !root.child('userNames').child(newData.val()).exists() ||
        root.child('userNames').child(newData.val()).val() == $uid"
    }
  }
}