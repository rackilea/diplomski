{
  "rules": {
    "usersToLogOut": {
      ".read": true,
      ".write": false
    },
    "posts": {
      ".read": "auth != null && !root.child('usersToLogOut').child(auth.uid).exists()"
    }
  }
}