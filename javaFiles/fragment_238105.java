ticket.acquire();
try {
    ...
}
catch (...) 
finally {
    ticket.release();
}