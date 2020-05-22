if (!wordOccurrencesMap.containsKey(word)) {
                pair = new Pair<>(word, 1);
                //System.out.println(Thread.currentThread().getName() + " Creating Pair: " + pair);
            } else {
                pair = wordOccurrencesMap.get(word);
                pair.setValue(pair.getValue() + 1);
                //System.out.println(Thread.currentThread().getName() + " Updating Pair: " + pair);
            }

            wordOccurrencesMap.put(word, pair);