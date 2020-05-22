findShortestPath(source,target):
  queue<- new queue
  visited <- {}
  Map<point,point> parents <- empty map
  queue.push(source)
  while (queue.empty() == false): 
     current <- queue.takeFirst()
     if (current.equals(target)):
         extract the path from source to destination using the map parents(*)
         return
     visited.add(current)
     for each p such that p and current are neighbors: //insert neighbors to queue
          if p is not in visited: 
                if (p is not an obstacle):
                   queue.push(p)
                   parents.put(p,current) //current is the parent of p