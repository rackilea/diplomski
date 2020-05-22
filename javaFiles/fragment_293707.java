void do_m_if_appropriate() {

  // x and y are assumed to be eg. member variables

  switch (x) {

    case 1:
      y = "foo";
      break;

    case 2:
      y = "bar";
      break;

    default:
      return; // this is the "goto equivalent" part
  }

  m(y);
}