cqlsh:test> SELECT type, dateOf(ts), bundle, version FROM Bundles WHERE
     type = 'OSS' and
     ts > minTimeuuid('2013-08-27 09:00:00')
     and ts < maxTimeuuid('2013-08-27 09:15:00');

     type | dateOf(ts)               | bundle       | version
    ------+--------------------------+--------------+---------
      OSS | 2013-08-27 09:14:27+0200 | SomeFramwork |  0.1.0a