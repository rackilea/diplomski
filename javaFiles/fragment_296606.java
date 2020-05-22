if (ctx.query() != null && ENABLE_LOGGING 
                        && ctx.sql().matches("(?i:.*?\\bmy_table_name\\b.*)") {
    LOGGER.debug(message.append(
             DynamicApplicationConfig.getStringProperty("API_ENV","dev"))
          .append(" - ")
          .append(create.renderInlined(ctx.query())).toString());
}