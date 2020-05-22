List<SampleDTO> output = 
    list.stream()
        .map(s-> {
                     SampleDTO n = new SampleDTO(s); // create new instance
                     n.setText(n.getText()+"xxx"); // mutate its state
                     return n; // return mutated instance
                 })
       .collect(Collectors.toList());