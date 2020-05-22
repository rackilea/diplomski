@Component
public class WebSocketAuthInterceptorAdapter extends ChannelInterceptorAdapter {

@Autowired
private DaoAuthenticationProvider userAuthenticationProvider;

@Override
public Message<?> preSend(final Message<?> message, final MessageChannel channel) throws AuthenticationException {

    final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
    StompCommand cmd = accessor.getCommand();

    if (StompCommand.CONNECT == cmd || StompCommand.SEND == cmd) {
        Authentication authenticatedUser = null;
        String authorization = accessor.getFirstNativeHeader("Authorization:);
        String credentialsToDecode = authorization.split("\\s")[1];
        String credentialsDecoded = StringUtils.newStringUtf8(Base64.decodeBase64(credentialsToDecode));
        String[] credentialsDecodedSplit = credentialsDecoded.split(":");
        final String username = credentialsDecodedSplit[0];
        final String password = credentialsDecodedSplit[1];
        authenticatedUser = userAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if (authenticatedUser == null) {
            throw new AccessDeniedException();
        } 
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        accessor.setUser(authenticatedUser);    
 }
    return message;
 }