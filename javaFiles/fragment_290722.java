package com.stackoverflow.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

public class SO23170832 {
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        static String[] array;
        static {
            array = new String[1000000];
            Arrays.fill(array, "AbabagalamagA");
        }
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public List<String> sequential(BenchmarkState state) {
        return
            Arrays.stream(state.array)
                  .map(x -> x.toLowerCase())
                  .collect(Collectors.toList());
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public List<String> parallel(BenchmarkState state) {
        return
            Arrays.stream(state.array)
                  .parallel()
                  .map(x -> x.toLowerCase())
                  .collect(Collectors.toList());
    }
}