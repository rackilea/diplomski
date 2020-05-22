try
{
    server->ffunction(0);
}
catch(const Interfface::myOwnException &ex)
{
    std::cout << ex.reason;
}