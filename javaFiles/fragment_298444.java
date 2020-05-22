<?php

$memcached = new Memcached();
$memcached->addserver('127.0.0.1', 11211);
$memcached->addserver('172.28.29.22', 11211);
var_dump($memcached->get('foo'));
var_dump($memcached->get('try'));
var_dump($memcached->get('sample'));
var_dump($memcached->get('ax-spadg-list'));