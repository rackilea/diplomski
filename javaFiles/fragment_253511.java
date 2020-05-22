RedisReactiveCommands<String, String> commands = …

Mono<TransactionResult> tx = commands.multi()
        .flatMap(ignore -> {

            commands.set("key", "value").doOnNext(…).subscribe();

            return commands.exec();
        });