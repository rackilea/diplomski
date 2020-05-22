List<Request> req = IntStream.range(0, sorted.size())
                                 .boxed()
                                 .flatMap(x -> {
                                     if (x == responses.size() - 1) {
                                         return Stream.of(fromResponse(responses.get(x)));
                                     }
                                     Response left = responses.get(x);
                                     Response right = responses.get(x + 1);

                                     if (!left.getEndDate().equals(right.getStartDate())) {
                                         Response oneMore = new Response(
                                             left.getEndDate(),
                                             right.getStartDate(),
                                             left.getId());
                                         return Stream.of(fromResponse(left), fromResponse(oneMore));
                                     } else {
                                         return Stream.of(fromResponse(left));
                                     }
                                 })
                                 .collect(Collectors.toList());