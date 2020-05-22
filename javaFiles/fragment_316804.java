<?php
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

$service = MemcacheServiceFactory::getMemcacheService();
$service->put("key", "this is the value");
echo $service->get("key"); // outputs "this is the value"