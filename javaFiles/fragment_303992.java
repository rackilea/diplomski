Student student = newStudent()
Iterator<ElementData> it = student.iterator(1);
ElementData element;
element = it.next()
element.getValue() // returns 2
element.getPosition() // returns 0
element = it.next() // moves to next position
element.getValue() // returns 8
element.getPosition() // returns 1