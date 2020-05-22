PriorityQueue<String> pq = new PriorityQueue<String>();
pq.add("banana");
pq.add("apple");
pq.add("orange");
pq.poll(); // Returns "apple"
pq.poll(); // Returns "banana"
pq.poll(); // Returns "orange"