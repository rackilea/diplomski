mockServerSocket = mock(ServerSocket.class);
// Set it first
mockTestClientSocket = mock(Socket.class);

try {
    // Then mock it
    when(mockServerSocket.accept()).thenReturn(mockTestClientSocket);
} catch (IOException e) {
    fail(e.getMessage());
}
...