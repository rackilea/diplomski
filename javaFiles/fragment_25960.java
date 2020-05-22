//this is in the HashMap class
function getBucketIndex(key) {
        var index = virtHashCode(key) % buckets.length;
        return index < 0 ? buckets.length + index : index;
}

function virtHashCode(obj) {
    if (obj.hashCode instanceof Function) {
      return obj.hashCode();
    }
   //other code omitted to keep this short
}