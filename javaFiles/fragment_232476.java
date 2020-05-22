static class Person {
    int height;
    Person (int height) {
        this.height = height;
    }
}

private static void run() {
    Stack<Person> stack = new Stack<>();
    Stack<Person> highest = new Stack<>();
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
        String[] queries = sc.nextLine().split(" ");
        int value = Integer.parseInt(queries[1]);
        switch (queries[0]) {
            case "join":
                Person person = new Person(value);
                if (highest.empty()) {
                    highest.push(person);
                } else if (value > highest.peek().height) {
                    highest.push(person);
                }
                stack.push(person);
                System.out.println(highest.size());
                break;
            case "leave":
                for (int j = 0; j < value; j++) {
                    Person left = stack.pop();
                    if (left == highest.peek()) {
                        highest.pop();
                    }
                }
                System.out.println(highest.size());
                break;
        }
    }
}