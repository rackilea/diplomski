public static void main(String[] args) {
    List<Sub> subs = new ArrayList<Sub>();
    doSomethingWith(subs); // The method doSomethingWith(List<Base>) in the type Main is not applicable for the arguments (List<Sub>)
}

private static void doSomethingWith(List<Base> bases) {
    // Do something with bases
}