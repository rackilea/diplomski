Long prevValue;
boolean done;
do {
  prevValue = errorMap.get(error);
  if (prevValue == null) {
    done = errorMap.putIfAbsent(error, 1L);
  } else {
    done = errorMap.replace(error, prevValue, newValue);
  }
} while (!done);