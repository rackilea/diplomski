package com.stackoverflow.user2352924;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MINUTES)
@Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 10, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Threads(2)
public class MicroBenchmark {

    private static List<Person> persons = new ArrayList<>();

    private int test;

    static {
        for(int i=0; i < 10000000; i++){
            persons.add(new Person("random", 26));
        }
    }

    @Benchmark
    public void sequentialCollectors() {
        test = 0;
        test += persons.stream().collect(Collectors.summingInt(p -> p.getAge()));
    }

    @Benchmark
    public void parallelCollectors() {
        test = 0;
        test += persons.parallelStream().collect(Collectors.summingInt(p -> p.getAge()));
    }

    @Benchmark
    public void sequentialMapSum() {
        test = 0;
        test += persons.stream().mapToInt(p -> p.getAge()).sum();
    }

    @Benchmark
    public void parallelMapSum() {
        test = 0;
        test += persons.parallelStream().mapToInt(p -> p.getAge()).sum();
    }

}