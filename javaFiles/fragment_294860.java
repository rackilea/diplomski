{
  "rules": {
    ".read": "auth != null", //non-authorised users CANT read
    ".write": "auth != null" //non-authorised users CANT write
  }
}