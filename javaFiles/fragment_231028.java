pop first element, i.e. 1; queue -> []
- if it has a left child, add it to the queue [2]
- if it has a right child, add it to the queue [2,3]

pop first element, i.e. 2; queue -> [3]
- if it has a left child, add it to the queue [3,4]
- if it has a right child, add it to the queue [3,4,5]

pop first element, i.e. 3; queue -> [4,5]
- if it has a left child, add it to the queue [4,5,6]
- if it has a right child, add it to the queue [4,5,6,7]

pop first element, i.e. 4; queue -> [5,6,7]
- if it has a left child, add it to the queue [5,6,7]
- if it has a right child, add it to the queue [5,6,7]

pop first element, i.e. 5; queue -> [6,7]
- if it has a left child, add it to the queue [6,7]
- if it has a right child, add it to the queue [6,7]

pop first element, i.e. 6; queue -> [7]
- if it has a left child, add it to the queue [7]
- if it has a right child, add it to the queue [7]

pop first element, i.e. 7; queue -> []
- if it has a left child, add it to the queue []
- if it has a right child, add it to the queue []

queue is empty