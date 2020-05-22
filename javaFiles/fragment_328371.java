Stream.<Supplier<RequestHandler>>of(
            TransformToDomainRequestHandler::new,
            ValidateRequestHandler::new,
            PersistenceHandler::new,
            TransformToDTORequestHandler::new)
            .sequential()
            .map(c -> c.get()) /* Create the handler instance */
            .reduce((processed, unProcessed) -> { /* chains all handlers together */
                RequestHandler previous = processed;
                RequestHandler target = previous.getNextRequestHandler();
                while (target != null && previous != null) {
                    previous = target;
                    target = target.getNextRequestHandler();
                }
                previous.setNextRequestHandler(unProcessed);
                return processed;
            }).get();