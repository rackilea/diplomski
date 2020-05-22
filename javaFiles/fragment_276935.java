@Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {


    UUID conversationId = lookupConversationOrCreateIfNecessary(request,
            response);

    log.debug("Binding conversation '{}' to request '{}'", conversationId,
            request);

    ConversationHolder.setId(conversationId);

    bindConversation(conversationId, request);

    try {
        filterChain.doFilter(request, response);
    } finally {
        log.debug("Unbinding conversation '{}' from request '{}'",
                conversationId, request);
        ConversationHolder.clear();
        unbindConversation(conversationId, request);
    }

}

@Override
protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return false; //to be sure both REQUEST and ASYNC are filtered
}