uint32_t len       = strlen( s );
uint32_t lenForNet = htonl( len );
char * p = buffer;
memmove( p, &lenForNet, sizeof( lenForNet ));
p += sizeof( lenForNet );
memmove( p, s, len );
send( sckt, buffer, len + sizeof( LenForNet ), 0 );