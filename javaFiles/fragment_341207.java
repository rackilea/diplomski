actualCategoriesCombined
            .apply(
                    ParDo.named("Actuals : Formatting")
                            .of(
                                    new DoFn<KV<String, CoGbkResult>, TableRow>() {
                                        @Override
                                        public void processElement(ProcessContext c) throws Exception {

                                            KV<String, CoGbkResult> e = c.element();

                                            Iterable<TableRow> actualTableRows = e.getValue().getAll(actualsTag);
                                            Iterable<Iterable<Map<String, String>>> categoriesAll = e.getValue().getAll(categoryTag);

                                            for (TableRow row : actualTableRows) {

                                                // Some of the actuals do not have categories
                                                if (categoriesAll.iterator().hasNext()) {
                                                    row.put("advertiser", categoriesAll.iterator().next());
                                                }

                                                c.output(row);
                                            }
                                        }
                                    }
                            )
            )