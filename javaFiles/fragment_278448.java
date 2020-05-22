consoleInput.windowAll(ProcessingTimeSessionWindows.withGap(Time.seconds(10)))
            .trigger(ProcessingTimeCountTrigger.of(10L))
            .process(new ProcessAllWindowFunction<String, String, TimeWindow>() {
        @Override
        public void process(Context context, Iterable<String> elements, Collector<String> out) throws Exception {
            List<String> alphaList = new ArrayList<>();
            elements.forEach(alphaList::add);
            out.collect("Time is " + new Date().toString());
            out.collect("Total " + alphaList.size() + " elements in window");
        }
    })