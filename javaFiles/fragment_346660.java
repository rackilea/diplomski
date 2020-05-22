let regex1 = /(?:cassy\.jobs \(.*?\))/,
  regex2 = /(?:\s*([a-z_]+) [a-z]+|PRIMARY KEY\s\((.*?)\))/gm,
  string = "CREATE TABLE cassy.jobs (job_id int, job_description text, maximum_salary double, minimum_salary double, PRIMARY KEY (job_id)) WITH read_repair_chance = 0.0 AND dclocal_read_repair_chance = 0.1 AND gc_grace_seconds = 864000 AND bloom_filter_fp_chance = 0.01 AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' } AND comment = '' AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold' : 32, 'min_threshold' : 4 } AND compression = { 'chunk_length_in_kb' : 64, 'class' : 'org.apache.cassandra.io.compress.LZ4Compressor' } AND default_time_to_live = 0 AND speculative_retry = '99PERCENTILE' AND min_index_interval = 128 AND max_index_interval = 2048 AND crc_check_chance = 1.0 AND cdc = false;, CREATE TABLE cassy.employees (employee_id int, email_add text, frst_name text, hire_date date, job_id int, last_name text, salary double, PRIMARY KEY (employee_id)) WITH read_repair_chance = 0.0 AND dclocal_read_repair_chance = 0.1 AND gc_grace_seconds = 864000 AND bloom_filter_fp_chance = 0.01 AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' } AND comment = '' AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold' : 32, 'min_threshold' : 4 } AND compression = { 'chunk_length_in_kb' : 64, 'class' : 'org.apache.cassandra.io.compress.LZ4Compressor' } AND default_time_to_live = 0 AND speculative_retry = '99PERCENTILE' AND min_index_interval = 128 AND max_index_interval = 2048 AND crc_check_chance = 1.0 AND cdc = false;]",
  createTable = regex1.exec(string),
  columnNames = [];

// Put all capture group matches into the columnNames array
while ((m = regex2.exec(createTable)) !== null) {
  m.forEach((match, groupIndex) => {
    if (match !== undefined && groupIndex !== 0) {
      columnNames.push(match)
    }
  });
}

console.log(columnNames)