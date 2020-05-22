int userId = 9;
Object[] args = new Object[]{"a", "list", "of", "args"}; // the "old" array
Object[] theNewArray = new Object[args.length + 1]; // a new array, 1 element bigger
System.arraycopy(args, 0, theNewArray, 1, args.length); // copy everything
theNewArray[0] = userId; // and insert you head element

// From now on, use "theNewArray"