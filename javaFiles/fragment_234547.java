@Override
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
    //super.dump(prefix, fd, writer, args);
    writer.println();
    writer.println("command line arguments:");
    writer.format("length: %d, args: %s", args.length, Arrays.toString(args)).println();
}