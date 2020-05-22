do { // note: not a real loop, used to skip call to m()
  switch (x) {

    case 1:
      y = "foo";
      break;

    case 2:
      y = "bar";
      break;

    default:
      continue; // "goto equivalent" part
  }

  m(y);
} while(false);