Future<String> conversionTask = ... // blah
Future<String> existingTask = conversions.putIfAbsent(pdfId, conversionTask);
if (existingTask != null) {
    conversionTask = existingTask;
}
// Either way, conversion is scheduled by now.