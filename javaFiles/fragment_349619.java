position.next = position.prev;          // TODO 3: position.prev.prev = position
position.prev = a = position.prev.prev; // TODO 4: a.next = position
//           ^                          //   same: position.prev.next = position   
//           |                          // *Error 1!*
//           + breaks TODO's 1 and 2, *Error 2!*
//           + breaks TODO 3, but we can instead: position.next.prev = position