{
  date: Date(...)
  friends: ['me', 'you', 'thatguy']
  ...
}
db.posts.ensureIndex({friends:1, date:-1})