selectQuery.addSelect(
    DSL.decode().value(ValidInfoGroup.InfoGroup)
                .when(DSL.val(null), ValidInfo.InfoGroup)
                .otherwise(ValidInfoGroup.InfoGroup)
                .as("InfoGroup")
);