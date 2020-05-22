CREATE TABLE schema_keyspaces (
  keyspace_name text PRIMARY KEY,
  durable_writes boolean,
  strategy_class text,
  strategy_options text
);


CREATE TABLE schema_columnfamilies (
  keyspace_name text,
  columnfamily_name text,
  bloom_filter_fp_chance double,
  caching text,
  column_aliases text,
  comment text,
  compaction_strategy_class text,
  compaction_strategy_options text,
  comparator text,
  compression_parameters text,
  default_read_consistency text,
  default_validator text,
  default_write_consistency text,
  gc_grace_seconds int,
  id int,
  key_alias text,
  key_aliases text,
  key_validator text,
  local_read_repair_chance double,
  max_compaction_threshold int,
  min_compaction_threshold int,
  read_repair_chance double,
  replicate_on_write boolean,
  subcomparator text,
  type text,
  value_alias text,
  PRIMARY KEY (keyspace_name, columnfamily_name)
);

CREATE TABLE schema_columns (
  keyspace_name text,
  columnfamily_name text,
  column_name text,
  component_index int,
  index_name text,
  index_options text,
  index_type text,
  validator text,
  PRIMARY KEY (keyspace_name, columnfamily_name, column_name)
);