public class MyTest {

public static void main(String[] args) {

    args = { "something", "something else", "you get the idea" };

    if (args.length < 1) { //HERE, it is always < 1
        System.out.println("Usage: java twitter4j.examples.tweets.ShowStatus [status id]");
        System.exit(-1);
    }
    try {