List<Integer> someList = Arrays.asList(1,2,3,4,5);
            someList.stream().map(i -> {
                System.out.println(Thread.currentThread().getName()+" Normal Stream : "+i);
                return i*2;
            }).forEach(System.out::println); // this is sequential stream

            System.out.println("this is parallel stream");

            someList.parallelStream().map(i -> {
                System.out.println(Thread.currentThread().getName()+" Parallel Stream : "+i);
                return i*2;
            }).forEachOrdered(System.out::println); // this is parallel stream