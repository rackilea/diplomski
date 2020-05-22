model.freqItemsets()
     .toJavaRDD()
     .map(new Function<FPGrowth.FreqItemset<String>, String>() {
            @Override
            public String call(FPGrowth.FreqItemset<String> fi) {
                return fi.javaItems() + " -> " + fi.freq();
            }
        }
     ).saveAsTextFile("/home/data/itemset");