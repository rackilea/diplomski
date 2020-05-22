int contentLength = connection.getContentLength();

if (contentLength != -1) {
    // Just do (readBytes / contentLength) * 100 to calculate the percentage.
} else {
    // You're lost. Show "Progress: unknown"
}