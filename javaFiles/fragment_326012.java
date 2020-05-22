Flowable.fromPublisher(FlowableTransformers.partialCollect(
        (Consumer<PartialCollectEmitter<LineData, Integer, 
        ListBuilder, ListDataModel>>) emitter -> {
            // Get or initialize collecting object
            ListBuilder lb = emitter.getAccumulator();
            if (lb == null) {
                lb = new ListBuilder();
                emitter.setAccumulator(lb);
            }

            if (emitter.demand() != 0) {
                boolean d = emitter.isComplete();
                if (emitter.size() != 0 && !d) {
                    LineData data = emitter.getItem(0);
                    emitter.dropItems(1);

                    // add returns the finished model if the prefix changes
                    ListDataModel model = lb.add(data);

                    if (model != null) {
                        emitter.next(model);
                    }
                } else if (d) {
                    if (!lb.isEmpty()) {
                        // clear returns the last model
                        emitter.next(lb.clear());
                    }
                    emitter.complete();
                    return;
                }
            }
            emitter.setIndex(0);
        }, Functions.emptyConsumer(), settings.getReadBufferSize() + 1).apply(
                Flowable.fromIterable(file.getFileNameList())
                        .concatMap(
                                fileName -> reader
                                        .getLineData(fileName)
                                        .buffer(settings.getReadBufferSize()))
                        .flatMap(Flowable::fromIterable)))