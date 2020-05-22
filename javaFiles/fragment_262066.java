Object wrappedEvent = wrapLogEvent(convertMutableToLog4jEvent(event));
if (wrappedEvent instanceof LogEventWithAdditionalFields) {
    LogEventWithAdditionalFields eventWithAdditionalFields = (LogEventWithAdditionalFields) wrappedEvent;
    eventWithAdditionalFields = customFunctionToApplyPatternConversion(event, eventWithAdditionalFields);

    wrappedEvent = eventWithAdditionalFields;
}
objectWriter.writeValue(writer, wrappedEvent);