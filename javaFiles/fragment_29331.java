MyObject objInCache =  cache.get(givenKey, ()->givenObj)

if(!objInCache.equals(givenobj)){
 //obje was in the cache,
//update object
}