return Mono.fromCallable(jdbc::queryForList) //fetches refs
                .subscribeOn(Schedulers.elastic())
                .flatMapMany(refList -> { //flatMapMany allows to convert Mono to Flux in flatMap operation
                            Flux<Tuple3<Map<Long, Product>, Map<Long, Item>, Map<Long, Warehouse>>> lookups = Mono.zip(fetchProducts(refList), fetchItems(refList), fetchWarehouses(refList))
                                    .cache().repeat(); //notice cache - it makes sure that Mono.zip is executed only once, not for each zipWith call

                            return Flux.fromIterable(refList)
                                    .zipWith(lookups);
                        }
                )
                .map(t -> {
                    Long ref = t.getT1();
                    Tuple3<Map<Long, Product>, Map<Long, Item>, Map<Long, Warehouse>> lookups = t.getT2();
                    JSONObject json = new JSONObject();
                    json.put("ref", ref);
                    json.put("product", lookups.getT1().get(ref));
                    json.put("item", lookups.getT2().get(ref));
                    json.put("warehouse", lookups.getT3().get(ref));
                    return json;
                });