{
  "rules": {
    ".read": "auth == null", //even non-authorised users CAN read
    ".write": "auth == null" //even non-authorised users CAN write
  }
}