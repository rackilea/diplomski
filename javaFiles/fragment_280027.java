private ClientDTO getClientDTOByClientId(Integer clientId)
{
    ClientDTO clientDTO = null;
    Cache clientCache = null;
    try
    {
        clientCache = ehCacheCacheManager.getCache("client");
        clientDTO = null;
        if (clientCache != null)
        {
            clientDTO = (ClientDTO) clientCache.get(clientId);
        }
        else
        {
            log.error("clientCache is null");
        }
    }
    catch (Exception e)
    {
        log.error("Couldnt retrieve client from cache. clientId=" + clientId);
    }
    return clientDTO;
}