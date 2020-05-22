for (int s = 0; s + 1 < args.length; s++) {
    if (args[s].equals(args[s + 1])) {
        result = true; 
        break;
    }
}