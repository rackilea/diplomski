while (true) {
        if (deque.isEmpty()) {
            System.out.println("No elements in queue");
        } else {
            System.out.println("consumed " + deque.removeLast());//note get will still have queue populated so remove seems better?
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
}