RichText richText = create.select()
            .from(RICH_TEXT)
            .where(RICH_TEXT.CODE.eq(code))
            .fetchOne(new RecordMapper<Record, RichText>() {

                @Override
                public RichText map(Record record) {

                    RichText richText = new RichText(
                            record.get(RICH_TEXT.CODE),
                            record.get(RICH_TEXT.RICH_STRING ),
                            new Font(
                                record.get(RICH_TEXT.FONTTITLEFAMILY), 
                                record.get(RICH_TEXT.FONTTITLESIZE)
                            ),
                            new Font(
                                record.get(RICH_TEXT.FONTSUBTITLEFAMILY), 
                                record.get(RICH_TEXT.FONTSUBTITLESIZE)
                            )

                        );

                    return richText;

                }
            });