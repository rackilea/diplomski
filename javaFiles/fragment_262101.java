public class prog2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of producers threads, number of consumer threads, size of the buffer, and the number of items to be produced.");
        System.out.println("Format Ex: 4 5 10 1000");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        int num_producers, num_consumers, size_buffer, num_items, num_consumed, num_produced;
        num_producers = Integer.parseInt(numbers[0]);
        num_consumers = Integer.parseInt(numbers[1]);
        size_buffer = Integer.parseInt(numbers[2]);
        num_items = Integer.parseInt(numbers[3]);

        ProducerConsumer implementation = new ProducerConsumer(size_buffer, num_items);
        Producer[] producers = new Producer[num_producers];
        Consumer[] consumers = new Consumer[num_consumers];

        for (int producer_count = 0; producer_count < num_producers; producer_count++) { //creating multiple producers
            producers[producer_count] = new Producer(implementation);
            producers[producer_count].start();
        }

        for (int consumer_count = 0; consumer_count < num_consumers; consumer_count++) { //creating multiple consumers
            consumers[consumer_count] = new Consumer(implementation);
            consumers[consumer_count].start();
        }

        for (int producer_count = 0; producer_count < num_producers; producer_count++) {
            producers[producer_count].join();
        }

        for (int consumer_count = 0; consumer_count < num_consumers; consumer_count++) {
            consumers[consumer_count].join();
        }

        System.out.println("Number of Produced items: " + implementation.num_produced + 
                " Number of Consumed items: " + implementation.num_consumed);
    }
}