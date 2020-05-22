class Account {
 ..
 static hasMany = [communities: Community]
 static mappedBy = [communities: 'owner']  //<-- will not work without this mapping
} 

class Community {
 ..
 static belongsTo = [owner: Account] //<-- assumes Account is owner
 static hasMany = [members: Account]
}