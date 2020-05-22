android {
  configurations{
     all*.exclude module: 'okhttp'
     all*.exclude module: 'okio'
   }
}