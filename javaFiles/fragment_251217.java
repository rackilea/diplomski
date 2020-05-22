import static Reversed.reversed;

...

List<String> someStrings = getSomeStrings();
for (String s : reversed(someStrings)) {
    doSomethingWith(s);
}