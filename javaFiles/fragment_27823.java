return IntStream.range(0, outputNeurons)
                //.parallel() uncomment to see difference in performance
                .mapToDouble(i -> IntStream.range(0, inputNeurons)
                        .mapToDouble(j -> weights[i][j] * x[j]).sum() + biases[i])
                .map(activation::apply)
                .toArray();