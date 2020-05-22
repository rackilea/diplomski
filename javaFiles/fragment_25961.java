function Iterator(conversion, removeItem) {
    var bucketIndex = 0;
    var itemIndex = -1;
    var endOfBuckets = false;
    var currentItem;

    function findNext() {
      while (!endOfBuckets) {
        ++itemIndex;
        if (bucketIndex >= buckets.length) {
          endOfBuckets = true;
        } else if (buckets[bucketIndex] === undef || itemIndex >= buckets[bucketIndex].length) {
          itemIndex = -1;
          ++bucketIndex;
        } else {
          return;
        }
      }
    }
    //more code