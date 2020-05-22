my @nutch_command = ("$Config{nutch_binary}",
             "crawl", "$Config{nutch_seed_dir}",
             "-solr", "$Config{solr_url}",
             "-d", "$Config{nutch_crawl_dir}",
             "-threads", "1",
             "-depth", "1");