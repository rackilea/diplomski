Deque<Runnable> queue = new ArrayDeque<>();
switch (Math.min(n, 4)) {
    case 4: queue.addFirst(MyClass::function_3);
    case 3: queue.addFirst(MyClass::function_2);
    case 2: queue.addFirst(MyClass::function_1);
}
for (Runnable r : queue)
    r.run();