Producer producer = new Producer();
    Observable.from(producer.produceShapes(20))
              .filter(shape -> shape instanceof Square || shape instanceof Circle && shape.getSize() > CIRCLE_MIN_SIZE)
             .flatMap(shape -> shape.getPaintingService().paint(shape));
             .buffer(5)
             // shapes will be a list of 5 shape
             .map(shapes -> new Box(shapes))
             .subscribe(box -> {
                  System.out.println("BOX ---> " + box.getName());
                  box.getShapes().foreach(System.out::println);
             });