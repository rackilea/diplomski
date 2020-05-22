List<Integer> output = new ArrayList<>();
arrayList.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String candidate) {
                try {
                    output.add(Integer.parseInt(candidate));
                } catch (Exception e) {
                }
            }
        });