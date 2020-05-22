switch( json.message.text ){
  case ~/\/login \w+/: 
    String userId
    text.toLowerCase().eachMatch( /\/login (\w+)/ ){ userId = it[ 1 ] }
    String telegramUserId = json.message.from.id
    saveJoin userId, telegramUserId
    break
 }