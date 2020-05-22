package com.example.tasks;

@Component
public class WeeklyReport implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Arrays.asList(args).stream().forEach(a -> System.out.println(a));
        if (!(args.length > 0 && args[0].equals("-task report:weekly"))) return;
        System.out.println("weekly report");
        System.exit(0);
    }