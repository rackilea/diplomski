socket         = desc->desc.s;
  channel       = desc->client_data;

  apr_pool_create(&p, global_context);
  status = apr_socket_addr_get(&remotesa, APR_LOCAL, socket);

  status = apr_sockaddr_info_get(&remotesa, NULL, remotesa->family, remotesa->port, 0, p);

  /* Grab the data */
  status = apr_socket_recvfrom(remotesa, socket, 0, buf, &len);
  if(status != APR_SUCCESS)
    {
      apr_pool_destroy(p);
      return;
    }  

  apr_sockaddr_ip_buffer_get(remoteip, 256, remotesa);

  /* Check the ACL */
  if(Ganglia_acl_action( channel->acl, remotesa) != GANGLIA_ACCESS_ALLOW)
    {
      apr_pool_destroy(p);
      return;
    }